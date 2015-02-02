package org.alfac.cyclone.web.controller;

import org.alfac.cyclone.model.PromotionPlan;
import org.apache.log4j.Logger;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

/**
 * @author Ivan
 */
@Named
@ViewScoped
public class PromotionPlanController implements Serializable {

    @SuppressWarnings("unused")
    private static final transient Logger LOG = Logger.getLogger(PromotionPlanController.class);

    private PromotionPlan instance;

    public void initializeController() {
        instance = new PromotionPlan();
    }

    public PromotionPlan getInstance() {
        return instance;
    }

    public void setInstance(PromotionPlan instance) {
        this.instance = instance;
    }
}
