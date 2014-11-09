package org.alfac.service;

import org.alfac.cyclone.common.persistence.DefaultEntityManager;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 * @author Ivan
 */
@Stateless
public class NumberService {

    @Inject
    @DefaultEntityManager
    private EntityManager entityManager;

    public Integer getValue() {
        return 14;
    }
}
