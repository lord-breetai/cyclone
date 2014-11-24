package org.alfac.cyclone.dao;

import org.alfac.cyclone.model.User;
import org.alfac.cyclone.persistence.context.RequestScopedEntityManagerResolver;
import org.apache.deltaspike.data.api.*;

/**
 * @author Ivan
 */
@Repository
@EntityManagerConfig(entityManagerResolver = RequestScopedEntityManagerResolver.class)
public abstract class UserRepository extends AbstractEntityRepository<User, Long> {

    @Query(value = "select user from User user left join fetch user.person where user.userName = :userName and user.password = :password", singleResult = SingleResultType.OPTIONAL)
    public abstract User findByUserNameAndPassword(@QueryParam("userName") String userName, @QueryParam("password") String password);

    @Query("select count(user) from User user where user.userName = :userName")
    public abstract Long countByUserName(@QueryParam("userName") String userName);
}
