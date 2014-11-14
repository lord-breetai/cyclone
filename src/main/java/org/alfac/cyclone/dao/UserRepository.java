package org.alfac.cyclone.dao;

import org.alfac.cyclone.common.persistence.DefaultEntityManagerResolver;
import org.alfac.cyclone.model.User;
import org.apache.deltaspike.data.api.*;

/**
 * @author Ivan
 */
@Repository
@EntityManagerConfig(entityManagerResolver = DefaultEntityManagerResolver.class)
public abstract class UserRepository extends AbstractEntityRepository<User, Long> {

    @Query(value = "select user from User user where user.userName = :userName and user.password = :password", singleResult = SingleResultType.OPTIONAL)
    public abstract User findByUserNameAndPassword(@QueryParam("userName") String userName, @QueryParam("password") String password);
}
