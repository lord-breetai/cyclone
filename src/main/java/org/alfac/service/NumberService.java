package org.alfac.service;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 * @author Ivan
 */
@Stateless
public class NumberService {

    @Inject
    private EntityManager entityManager;

    public Integer getValue() {
        return 14;
    }
}
