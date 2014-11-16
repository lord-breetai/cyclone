package org.alfac.cyclone.service;

import org.alfac.cyclone.dao.PersonRepository;
import org.alfac.cyclone.model.Person;

import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * @author Ivan
 */
@Stateless
public class PersonService {

    @Inject
    private PersonRepository repository;

    public Person createPerson(Person instance) {
        return repository.save(instance);
    }
}
