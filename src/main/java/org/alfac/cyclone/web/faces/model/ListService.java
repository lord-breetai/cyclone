package org.alfac.cyclone.web.faces.model;

import org.alfac.cyclone.framework.persistence.context.RequestScopedEntityManager;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.Map;

/**
 * @author Ivan
 */
@Stateless
public class ListService {

    @Inject
    @RequestScopedEntityManager
    private EntityManager entityManager;

    public <T> QueryResult<T> loadElements(Class<T> entityType, int first, int pageSize, String selectQL, String countQL, Map<String, Object> filters) {
        TypedQuery<T> selectQuery = createQuery(entityType, selectQL, filters)
                .setFirstResult(first)
                .setMaxResults(pageSize);

        TypedQuery<Long> countQuery = createQuery(Long.class, countQL, filters);

        return new QueryResult<>(countQuery.getSingleResult().intValue(), selectQuery.getResultList());
    }

    private <T> TypedQuery<T> createQuery(Class<T> entityClazz, String jpaQL, Map<String, Object> filters) {
        TypedQuery<T> query = entityManager.createQuery(jpaQL, entityClazz);

        for (String filterKey : filters.keySet()) {
            Object filterValue = filters.get(filterKey);

            query.setParameter(filterKey, filterValue);
        }

        return query;
    }
}
