package org.alfac.cyclone.persistence.context;

import org.apache.deltaspike.data.api.EntityManagerResolver;

import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 * @author Ivan
 */
public class RequestScopedEntityManagerResolver implements EntityManagerResolver {

    @Inject
    @RequestScopedEntityManager
    private EntityManager entityManager;

    @Override
    public EntityManager resolveEntityManager() {
        return entityManager;
    }
}
