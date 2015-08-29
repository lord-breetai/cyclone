package org.alfac.cyclone.service;

import org.alfac.cyclone.dao.PromotionEntryRepository;
import org.alfac.cyclone.dao.PromotionPlanRepository;
import org.alfac.cyclone.exception.DuplicatedEntryException;
import org.alfac.cyclone.model.PromotionEntry;
import org.alfac.cyclone.model.PromotionPlan;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

/**
 * @author Ivan.
 */
@Stateless
public class PromotionPlanService {

    @Inject
    private PromotionPlanRepository promotionPlanRepository;

    @Inject
    private PromotionEntryRepository promotionEntryRepository;

    public PromotionPlan create(PromotionPlan promotionPlan, List<PromotionEntry> promotionEntries) throws DuplicatedEntryException {
        promotionPlan.setCode(generatePromotionPlanCode());

        promotionPlan = promotionPlanRepository.save(promotionPlan);

        for (PromotionEntry promotionEntry : promotionEntries) {
            promotionEntry.setPromotionPlan(promotionPlan);

            promotionEntryRepository.save(promotionEntry);
        }

        return promotionPlan;
    }

    private String generatePromotionPlanCode() {
        Long counter = promotionPlanRepository.countAllPromotionPlans();

        if (null == counter) {
            counter = 0L;
        }

        return "PP-" + (counter + 1);
    }
}
