package org.alfac.cyclone.service;

import org.alfac.cyclone.dao.UserRepository;
import org.alfac.cyclone.model.User;

import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * @author Ivan
 */
@Stateless
public class UserSecurityService {

    @Inject
    private UserRepository repository;

    public User findUser(String userName, String password) {
        return repository.findByUserNameAndPassword(userName, password);
    }
}
