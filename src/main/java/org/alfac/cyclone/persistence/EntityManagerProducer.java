package org.alfac.cyclone.persistence;

import org.alfac.cyclone.persistence.context.RequestScopedEntityManager;

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
public class EntityManagerProducer {

    @PersistenceUnit
    private EntityManagerFactory factory;

    @Produces
    @RequestScoped
    @RequestScopedEntityManager
    public EntityManager createRequestScopedInstance() {
        return factory.createEntityManager();
    }

    public void disposeRequestScopedInstance(@Disposes @RequestScopedEntityManager EntityManager instance) {
        if (instance.isOpen()) {
            instance.close();
        }
    }
}
