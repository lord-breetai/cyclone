package org.alfac.cyclone.web.controller;

import org.alfac.cyclone.exception.DuplicatedEntryException;
import org.alfac.cyclone.framework.controller.action.annotation.Action;
import org.alfac.cyclone.framework.controller.action.annotation.Exception;
import org.alfac.cyclone.framework.controller.action.annotation.Success;
import org.alfac.cyclone.model.Degree;
import org.alfac.cyclone.service.DegreeService;
import org.apache.log4j.Logger;
import org.primefaces.event.SelectEvent;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

/**
 * @author Ivan
 */
@Named
@ViewScoped
public class DegreeController implements Serializable {

    @SuppressWarnings("unused")
    private static final transient Logger LOG = Logger.getLogger(DegreeController.class);

    @Inject
    private DegreeService degreeService;

    private Degree instance;

    public void initializeController() {
        instance = new Degree();
    }

    public void onSelect(SelectEvent event) {
        instance = degreeService.findDegree(((Degree) event.getObject()).getId());
    }

    @Action(
            onSuccess = @Success(
                    message = "DegreeController.info.entrySavedMsg",
                    update = {"degreeDataTableId"},
                    execute = {"PF('createDegreeDialog').hide()"}
            ),
            onError = {
                    @Exception(clazz = DuplicatedEntryException.class, message = "DegreeController.error.duplicateEntryMsg")
            }
    )
    public void createAction() {
        degreeService.create(instance);

        initializeController();
    }

    public Degree getInstance() {
        return instance;
    }

    public void setInstance(Degree instance) {
        this.instance = instance;
    }
}
