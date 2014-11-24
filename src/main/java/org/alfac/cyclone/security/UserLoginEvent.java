package org.alfac.cyclone.security;

import org.alfac.cyclone.model.User;

/**
 * @author Ivan
 */
public class UserLoginEvent {

    private User user;

    public static UserLoginEvent getInstance(User user) {
        return new UserLoginEvent(user);
    }

    public UserLoginEvent(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
