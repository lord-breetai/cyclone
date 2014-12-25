package org.alfac.cyclone.dao;

import org.alfac.cyclone.framework.persistence.context.RequestScopedEntityManagerResolver;
import org.alfac.cyclone.model.Degree;
import org.apache.deltaspike.data.api.AbstractEntityRepository;
import org.apache.deltaspike.data.api.EntityManagerConfig;
import org.apache.deltaspike.data.api.Repository;

/**
 * @author Ivan
 */
@Repository
@EntityManagerConfig(entityManagerResolver = RequestScopedEntityManagerResolver.class)
public abstract class DegreeRepository extends AbstractEntityRepository<Degree, Long> {
}
