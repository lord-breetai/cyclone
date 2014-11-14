package org.alfac.cyclone.common.persistence;

import org.apache.deltaspike.data.api.EntityManagerResolver;

import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 * @author Ivan
 */
public class DefaultEntityManagerResolver implements EntityManagerResolver {

    @Inject
    @DefaultEntityManager
    private EntityManager entityManager;

    @Override
    public EntityManager resolveEntityManager() {
        return entityManager;
    }
}
