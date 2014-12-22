package org.alfac.cyclone.dao;

import org.alfac.cyclone.model.Country;
import org.alfac.cyclone.persistence.context.RequestScopedEntityManagerResolver;
import org.apache.deltaspike.data.api.*;

/**
 * @author Ivan
 */
@Repository
@EntityManagerConfig(entityManagerResolver = RequestScopedEntityManagerResolver.class)
public abstract class CountryRepository extends AbstractEntityRepository<Country, Long> {

    @Query("select count(country) from Country country where country.name = :countryName")
    public abstract Long countByCountryName(@QueryParam("countryName") String countryName);
}
