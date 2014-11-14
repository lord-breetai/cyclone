package org.alfac.controller;

import org.alfac.cyclone.service.UserService;
import org.alfac.service.NumberService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * @author Ivan
 */
@Named
@RequestScoped
public class NumberController {

    private Integer value;

    @Inject
    private NumberService service;

    @Inject
    private UserService userService;


    public Integer getValue() {
        userService.logginUser("aaa", "bbb");
        if (null == value) {
            value = service.getValue();
        }

        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
