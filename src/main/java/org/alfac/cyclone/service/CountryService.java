package org.alfac.cyclone.service;

import org.alfac.cyclone.dao.CountryRepository;
import org.alfac.cyclone.model.Country;

import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * @author Ivan
 */
@Stateless
public class CountryService {

    @Inject
    private CountryRepository repository;

    public Country findCountry(Long id) {
        Country instance = repository.findBy(id);

        if (null == instance) {
            //TODO: a exception must be throws
        }

        return instance;
    }

    public void create(Country instance) {
        repository.save(instance);
    }
}
