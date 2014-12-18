package org.alfac.cyclone.web.controller;

import org.alfac.cyclone.model.Country;
import org.alfac.cyclone.service.CountryService;
import org.apache.log4j.Logger;
import org.primefaces.context.RequestContext;
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
public class CountryController implements Serializable {

    @SuppressWarnings("unused")
    private static final transient Logger LOG = Logger.getLogger(CountryController.class);

    @Inject
    private CountryService service;

    private Country instance;

    public void initializeController() {
        instance = new Country();
    }

    public void onSelect(SelectEvent event) {
        instance = service.findCountry(((Country) event.getObject()).getId());
    }

    public void createAction() {
        service.create(instance);

        RequestContext.getCurrentInstance().execute("PF('createCountryDialog').hide()");
        RequestContext.getCurrentInstance().update("countryDataTableId");
    }

    public Country getInstance() {
        return instance;
    }

    public void setInstance(Country instance) {
        this.instance = instance;
    }
}
