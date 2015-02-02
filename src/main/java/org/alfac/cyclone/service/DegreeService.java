package org.alfac.cyclone.service;

import org.alfac.cyclone.dao.DegreeRepository;
import org.alfac.cyclone.exception.DuplicatedEntryException;
import org.alfac.cyclone.exception.EntryNotFoundException;
import org.alfac.cyclone.model.Degree;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

/**
 * @author Ivan
 */

@Stateless
public class DegreeService {

    @Inject
    private DegreeRepository degreeRepository;

    public List<Degree> findAll() {
        return degreeRepository.findAll();
    }

    public List<Degree> findDegreeByIdNotIn(List<Long> elements) {
        if (null == elements || elements.isEmpty()) {
            return findAll();
        }

        return degreeRepository.findByIdNotIn(elements);
    }

    public Degree findDegree(Long id) throws EntryNotFoundException {
        Degree instance = degreeRepository.findBy(id);

        if (null == instance) {
            throw new EntryNotFoundException();
        }
        return instance;
    }

    //TODO the duplicate validation is pending
    public Degree create(Degree instance) throws DuplicatedEntryException {
        return degreeRepository.save(instance);
    }
}
