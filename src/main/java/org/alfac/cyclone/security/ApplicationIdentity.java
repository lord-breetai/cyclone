package org.alfac.cyclone.security;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 * @author Ivan
 */
@Named
@RequestScoped
public class ApplicationIdentity {

    private String userName;

    private String password;


    public String login() {
        return "Success";
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
