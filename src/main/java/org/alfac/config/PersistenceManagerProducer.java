package org.alfac.config;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Default;
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
    private EntityManagerFactory entityManagerFactory;

    @Produces
    @Default
    @RequestScoped
    public EntityManager create() {
        return entityManagerFactory.createEntityManager();
    }

    public void dispose(@Disposes @Default EntityManager entityManager) {
        if (entityManager.isOpen()) {
            entityManager.close();
        }
    }
}
