package org.alfac.cyclone.dao;

import org.alfac.cyclone.model.Country;
import org.alfac.cyclone.persistence.context.RequestScopedEntityManagerResolver;
import org.apache.deltaspike.data.api.AbstractEntityRepository;
import org.apache.deltaspike.data.api.EntityManagerConfig;
import org.apache.deltaspike.data.api.Repository;

/**
 * @author Ivan
 */
@Repository
@EntityManagerConfig(entityManagerResolver = RequestScopedEntityManagerResolver.class)
public abstract class CountryRepository extends AbstractEntityRepository<Country, Long> {
}
