package org.alfac.cyclone.service;

import org.alfac.cyclone.model.User;

import javax.ejb.Stateless;

/**
 * @author Ivan
 */
@Stateless
public class UserSecurityService {

    public User findUser(String userName, String password) {
        return new User();
    }
}
