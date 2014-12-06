package org.alfac.cyclone.web.controller;

import org.alfac.cyclone.model.Country;
import org.alfac.cyclone.web.faces.model.ListService;
import org.alfac.cyclone.web.faces.model.PagedDataModel;
import org.alfac.cyclone.web.faces.model.annotation.DataModelConfig;
import org.alfac.cyclone.web.faces.model.annotation.DataModelFilter;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * @author Ivan
 */
@DataModelConfig(
        selectJpaQL = "select country from Country country",
        countJpaQL = "select count(country) from Country country"
)
@Named
@ViewScoped
public class CountryDataModel extends PagedDataModel<Country, CountryDataModel> {

    @DataModelFilter(
            filterName = "countryName",
            expression = "lower(country.name) like concat('%', lower(:countryName), '%')"
    )
    private String countryName;

    @Inject
    private ListService listService;

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }


    public void search() {

    }

    @Override
    protected Class<Country> getEntityClass() {
        return Country.class;
    }

    @Override
    public Class<CountryDataModel> getDataModelConfigClass() {
        return CountryDataModel.class;
    }

    @Override
    public CountryDataModel getDataModelConfigInstance() {
        return this;
    }

    @Override
    protected ListService getListService() {
        return listService;
    }
}
