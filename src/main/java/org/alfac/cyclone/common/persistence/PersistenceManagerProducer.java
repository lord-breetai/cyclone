package org.alfac.cyclone.common.persistence;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

/**
 * @author Ivan
 */
@ApplicationScoped
public class PersistenceManagerProducer {

    @PersistenceUnit
    private EntityManagerFactory factory;

    @Produces
    @RequestScoped
    @DefaultEntityManager
    public EntityManager create() {
        return factory.createEntityManager();
    }

    public void dispose(@Disposes @DefaultEntityManager EntityManager entityManager) {
        if (entityManager.isOpen()) {
            entityManager.close();
        }
    }
}
