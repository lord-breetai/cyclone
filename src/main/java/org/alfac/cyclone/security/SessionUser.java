package org.alfac.cyclone.security;

import org.alfac.cyclone.model.User;
import org.apache.log4j.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Observes;
import javax.inject.Named;
import java.io.Serializable;

/**
 * @author Ivan
 */

@Named
@SessionScoped
public class SessionUser implements Serializable {

    @SuppressWarnings("unused")
    private static final transient Logger LOG = Logger.getLogger(SessionUser.class);

    private User user;

    public void onLogin(@Observes UserLoginEvent event) {
        this.user = event.getUser();
    }

    public User getUser() {
        return user;
    }

    public boolean isAuthenticated() {
        return null != user;
    }

    private void initialize() {
        user = null;
    }

    @PostConstruct
    void postConstruct() {
        initialize();
    }
}
