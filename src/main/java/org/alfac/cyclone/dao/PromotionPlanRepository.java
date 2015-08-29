package org.alfac.cyclone.dao;

import org.alfac.cyclone.framework.persistence.context.RequestScopedEntityManagerResolver;
import org.alfac.cyclone.model.PromotionPlan;
import org.apache.deltaspike.data.api.AbstractEntityRepository;
import org.apache.deltaspike.data.api.EntityManagerConfig;
import org.apache.deltaspike.data.api.Query;
import org.apache.deltaspike.data.api.Repository;

/**
 * @author ivan.
 */
@Repository
@EntityManagerConfig(entityManagerResolver = RequestScopedEntityManagerResolver.class)
public abstract class PromotionPlanRepository extends AbstractEntityRepository<PromotionPlan, Long> {

    @Query("select count(promotionPlan) from PromotionPlan promotionPlan")
    public abstract Long countAllPromotionPlans();
}
