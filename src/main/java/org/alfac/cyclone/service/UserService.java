package org.alfac.cyclone.service;

import org.alfac.cyclone.dao.UserRepository;
import org.alfac.cyclone.model.User;

import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * @author Ivan
 */
@Stateless
public class UserService {

    @Inject
    private UserRepository repository;


    public User logginUser(String userName, String password) {
        User user = repository.findByUserNameAndPassword(userName, password);

        System.out.println("fffffff");
        return user;
    }
}
