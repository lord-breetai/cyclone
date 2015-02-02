package org.alfac.cyclone.web.controller;

import org.alfac.cyclone.model.PromotionPlan;
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
        selectJpaQL = "select promotionPlan from PromotionPlan promotionPlan",
        countJpaQL = "select count(promotionPlan) from PromotionPlan promotionPlan"
)
@Named
@ViewScoped
public class PromotionPlanDataModel extends PagedDataModel<PromotionPlan, PromotionPlanDataModel> {

    @Inject
    private ListService listService;

    @DataModelFilter(
            filterName = "promotionPlanCode",
            expression = "promotionPlan.code = :promotionPlanCode"
    )
    private String promotionPlanCode;


    @DataModelFilter(
            filterName = "promotionPlanName",
            expression = "lower(promotionPlan.name) like concat('%', lower(:promotionPlanName), '%')"
    )
    private String promotionPlanName;

    public void search() {
    }

    @Override
    protected ListService getListService() {
        return listService;
    }

    @Override
    protected Class<PromotionPlan> getEntityClass() {
        return PromotionPlan.class;
    }

    @Override
    public Class<PromotionPlanDataModel> getDataModelConfigClass() {
        return PromotionPlanDataModel.class;
    }

    @Override
    public PromotionPlanDataModel getDataModelConfigInstance() {
        return this;
    }

    public String getPromotionPlanCode() {
        return promotionPlanCode;
    }

    public void setPromotionPlanCode(String promotionPlanCode) {
        this.promotionPlanCode = promotionPlanCode;
    }

    public String getPromotionPlanName() {
        return promotionPlanName;
    }

    public void setPromotionPlanName(String promotionPlanName) {
        this.promotionPlanName = promotionPlanName;
    }
}
