package org.alfac.cyclone.service;

import org.alfac.cyclone.dao.UserRepository;
import org.alfac.cyclone.model.Person;
import org.alfac.cyclone.model.User;

import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * @author Ivan
 */
@Stateless
public class UserService {

    @Inject
    private UserRepository repository;

    @Inject
    private PersonService personService;

    public void createUser(User user, Person person) {
        if (repository.countByUserName(user.getUserName()) > 0) {
            //TODO A exception must be throws because the userName already exists

            return;
        }

        person = personService.createPerson(person);

        user.setPerson(person);

        repository.save(user);

        repository.flush();
    }

    public User logginUser(String userName, String password) {
        User user = repository.findByUserNameAndPassword(userName, password);

        System.out.println("fffffff");
        return user;
    }
}
