package org.alfac.cyclone.dao;

import org.alfac.cyclone.framework.persistence.context.RequestScopedEntityManagerResolver;
import org.alfac.cyclone.model.Degree;
import org.apache.deltaspike.data.api.*;

import java.util.List;

/**
 * @author Ivan
 */
@Repository
@EntityManagerConfig(entityManagerResolver = RequestScopedEntityManagerResolver.class)
public abstract class DegreeRepository extends AbstractEntityRepository<Degree, Long> {


    @Query("select degree from Degree degree where degree.id not in (:elements)")
    public abstract List<Degree> findByIdNotIn(@QueryParam("elements") List<Long> elements);
}
