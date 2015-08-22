package org.alfac.cyclone.web.controller;

import org.alfac.cyclone.exception.DuplicatedEntryException;
import org.alfac.cyclone.framework.controller.action.annotation.*;
import org.alfac.cyclone.model.PromotionEntry;
import org.alfac.cyclone.service.DegreeService;
import org.apache.log4j.Logger;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

/**
 * @author Ivan
 */
@Named
@ViewScoped
public class CreatePromotionPlanController implements Serializable {

    @SuppressWarnings("unused")
    private static final transient Logger LOG = Logger.getLogger(CreatePromotionPlanController.class);

    @Inject
    private PromotionPlanController promotionPlanController;

    @Inject
    private PromotionPlanTableController promotionPlanTableController;

    @Inject
    private PromotionEntryController promotionEntryController;

    @Inject
    private DegreeService degreeService;

    public void initializeController() {
        promotionPlanController.initializeController();
        promotionPlanTableController.initializeController();
    }

    public void initializePromotionEntryController() {
        promotionEntryController.initializeController(
                promotionPlanTableController.loadSourceDegrees(),
                promotionPlanTableController.loadTargetDegrees()
        );
    }

    @Action(
            onSuccess = @Success(
                    message = "CreatePromotionPlanController.info.entryAddedMsg",
                    update = {"promotionEntryTableId"},
                    execute = {"PF('createPromotionEntryDialog').hide()"}
            )
    )
    public void addPromotionEntry() {
        promotionEntryController.prepareInstance();
        PromotionEntry instance = promotionEntryController.getInstance();

        promotionPlanTableController.registerPromotionEntry(instance);
    }

    @Action(
            onSuccess = @Success(
                    message = "CreatePromotionPlanController.info.entryRemovedMsg",
                    update = "promotionEntryTableId"
            )
    )
    public void removePromotionEntry(PromotionEntry instance) {
        promotionPlanTableController.removePromotionEntry(instance);
    }

    @Action(
            onSuccess = @Success(
                    message = "CreatePromotionPlanController.info.entrySavedMsg",
                    update = {"promotionPlanDataTableId"},
                    execute = {"PF('createPromotionPlanDialog').hide()"}
            )
    )
    public void createAction() {
        initializeController();
    }
}
