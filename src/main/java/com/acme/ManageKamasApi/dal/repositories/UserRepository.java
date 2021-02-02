package com.acme.ManageKamasApi.dal.repositories;

import com.acme.ManageKamasApi.dal.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * User Repository: extends the crud repository and allows crud operations on users.
 */
public interface UserRepository extends CrudRepository<User, Integer> {

    @Query("SELECT new com.acme.ManageKamasApi.dal.models.User(u.id, u.login, u.email, u.password) FROM User u " +
            "WHERE u.login = ?1")
    User findByLogin(String login);
}
