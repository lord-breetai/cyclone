package org.alfac.cyclone.service;

import org.alfac.cyclone.dao.CountryRepository;
import org.alfac.cyclone.exception.DuplicatedEntryException;
import org.alfac.cyclone.exception.EntryNotFoundException;
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

    public Country findCountry(Long id) throws EntryNotFoundException {
        Country instance = repository.findBy(id);

        if (null == instance) {
            throw new EntryNotFoundException();
        }

        return instance;
    }

    public Country create(Country instance) throws DuplicatedEntryException {
        Long countryNameCounter = repository.countByCountryName(instance.getName());
        if (countryNameCounter > 0) {
            throw new DuplicatedEntryException();
        }

        return repository.save(instance);
    }
}
