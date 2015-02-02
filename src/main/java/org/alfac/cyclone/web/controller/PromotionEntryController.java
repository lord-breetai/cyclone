package org.alfac.cyclone.web.controller;

import org.alfac.cyclone.framework.persistence.JPAEntityUtil;
import org.alfac.cyclone.model.Degree;
import org.alfac.cyclone.model.LeadTimeType;
import org.alfac.cyclone.model.PromotionEntry;
import org.alfac.cyclone.service.DegreeService;
import org.apache.log4j.Logger;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Ivan
 */
@Named
@ViewScoped
public class PromotionEntryController implements Serializable {

    @SuppressWarnings("unused")
    private static final transient Logger LOG = Logger.getLogger(PromotionEntryController.class);

    private Long sourceDegreeId;

    private Long targetDegreeId;

    private String leadTimeType;

    private PromotionEntry instance;

    private List<Long> handledSourceDegreeIds;

    private List<Long> handledTargetDegreeIds;

    private List<Degree> sourceDegrees;

    private List<Degree> targetDegrees;

    private List<LeadTimeType> leadTimeTypes;

    @Inject
    private DegreeService degreeService;

    public void initializeController(List<Degree> handledSourceDegrees, List<Degree> handledTargetDegrees) {
        instance = new PromotionEntry();
        sourceDegreeId = null;
        targetDegreeId = null;
        leadTimeType = null;
        handledSourceDegreeIds = JPAEntityUtil.loadIds(handledSourceDegrees);
        handledTargetDegreeIds = JPAEntityUtil.loadIds(handledTargetDegrees);
        leadTimeTypes = Arrays.asList(LeadTimeType.values());

        initializeSourceDegrees();
        initializeTargetDegrees();
    }

    public void prepareInstance() {
        Degree sourceDegree = degreeService.findDegree(sourceDegreeId);
        Degree targetDegree = degreeService.findDegree(targetDegreeId);

        LeadTimeType type = LeadTimeType.valueOf(leadTimeType);

        instance.setSourceDegree(sourceDegree);
        instance.setTargetDegree(targetDegree);
        instance.setLeadTimeType(type);
    }

    public void reloadTargetDegrees() {
        initializeTargetDegrees();
    }

    public PromotionEntry getInstance() {
        return instance;
    }

    public void setInstance(PromotionEntry instance) {
        this.instance = instance;
    }

    public Long getSourceDegreeId() {
        return sourceDegreeId;
    }

    public void setSourceDegreeId(Long sourceDegreeId) {
        this.sourceDegreeId = sourceDegreeId;
    }

    public Long getTargetDegreeId() {
        return targetDegreeId;
    }

    public void setTargetDegreeId(Long targetDegreeId) {
        this.targetDegreeId = targetDegreeId;
    }

    public String getLeadTimeType() {
        return leadTimeType;
    }

    public void setLeadTimeType(String leadTimeType) {
        this.leadTimeType = leadTimeType;
    }

    public List<Degree> getSourceDegrees() {
        return sourceDegrees;
    }

    public List<Degree> getTargetDegrees() {
        return targetDegrees;
    }

    public List<LeadTimeType> getLeadTimeTypes() {
        return leadTimeTypes;
    }

    private void initializeSourceDegrees() {
        if (handledSourceDegreeIds.isEmpty()) {
            sourceDegrees = degreeService.findAll();
        } else {
            sourceDegrees = degreeService.findDegreeByIdNotIn(handledSourceDegreeIds);
        }
    }

    private void initializeTargetDegrees() {
        List<Long> handledDegreeIds = new ArrayList<>();
        handledDegreeIds.addAll(handledSourceDegreeIds);
        handledDegreeIds.addAll(handledTargetDegreeIds);

        if (null != sourceDegreeId) {
            handledDegreeIds.add(sourceDegreeId);
        }

        if (handledDegreeIds.isEmpty()) {
            targetDegrees = degreeService.findAll();
        } else {
            targetDegrees = degreeService.findDegreeByIdNotIn(handledDegreeIds);
        }
    }
}
