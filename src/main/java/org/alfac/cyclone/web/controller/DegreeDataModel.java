package org.alfac.cyclone.web.controller;

import org.alfac.cyclone.model.Degree;
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
        selectJpaQL = "select degree from Degree degree",
        countJpaQL = "select count(degree) from Degree degree"
)
@Named
@ViewScoped
public class DegreeDataModel extends PagedDataModel<Degree, DegreeDataModel> {

    @DataModelFilter(
            filterName = "degreeName",
            expression = "lower(degree.name) like concat('%', lower(:degreeName), '%')"
    )
    private String degreeName;

    @Inject
    private ListService listService;

    public void search() {

    }

    @Override
    protected ListService getListService() {
        return listService;
    }

    @Override
    protected Class<Degree> getEntityClass() {
        return Degree.class;
    }

    @Override
    public Class<DegreeDataModel> getDataModelConfigClass() {
        return DegreeDataModel.class;
    }

    @Override
    public DegreeDataModel getDataModelConfigInstance() {
        return this;
    }

    public String getDegreeName() {
        return degreeName;
    }

    public void setDegreeName(String degreeName) {
        this.degreeName = degreeName;
    }
}
