package org.alfac.cyclone.web.controller;

import org.alfac.cyclone.model.Degree;
import org.alfac.cyclone.model.PromotionEntry;
import org.apache.log4j.Logger;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Ivan
 */
@Named
@ViewScoped
public class PromotionPlanTableController implements Serializable {

    @SuppressWarnings("unused")
    private static final transient Logger LOG = Logger.getLogger(PromotionPlanTableController.class);

    private LinkedList<PromotionEntry> promotionTable;

    public void initializeController() {
        promotionTable = new LinkedList<>();
    }

    public void registerPromotionEntry(PromotionEntry instance) {
        Integer index = promotionTable.size();
        instance.setPosition(index);

        promotionTable.add(instance);
    }

    public void removePromotionEntry(PromotionEntry instance) {
        Integer index = promotionTable.indexOf(instance);

        if (index > -1) {
            promotionTable.remove(instance);
        }
    }

    public LinkedList<PromotionEntry> getPromotionTable() {
        return promotionTable;
    }

    public void setPromotionTable(LinkedList<PromotionEntry> promotionTable) {
        this.promotionTable = promotionTable;
    }

    public List<Degree> loadSourceDegrees() {
        List<Degree> result = new ArrayList<>();
        for (PromotionEntry promotionEntry : promotionTable) {
            result.add(promotionEntry.getSourceDegree());
        }

        return result;
    }

    public List<Degree> loadTargetDegrees() {
        List<Degree> result = new ArrayList<>();
        for (PromotionEntry promotionEntry : promotionTable) {
            result.add(promotionEntry.getTargetDegree());
        }

        return result;
    }
}
