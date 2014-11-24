package org.alfac.cyclone.security;

import org.alfac.cyclone.model.User;
import org.alfac.cyclone.service.UserSecurityService;
import org.apache.log4j.Logger;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * @author Ivan
 */
@Named
@RequestScoped
public class ApplicationIdentity {

    private static final Logger LOG = Logger.getLogger(ApplicationIdentity.class);

    private String userName;

    private String password;

    @Inject
    private Event<UserLoginEvent> userLoginEvent;

    @Inject
    private UserSecurityService securityService;

    public String login() {

        User user = securityService.findUser(userName, password);

        if (null != user) {
            userLoginEvent.fire(UserLoginEvent.getInstance(user));

            LOG.info("Welcome User [" + userName + "]");
            return "Success";
        }

        return null;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
