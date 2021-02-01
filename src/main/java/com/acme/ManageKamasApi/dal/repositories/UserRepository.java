package com.acme.ManageKamasApi.dal.repositories;

import com.acme.ManageKamasApi.dal.models.User;
import org.springframework.data.repository.CrudRepository;

/**
 * User Repository: extends the crud repository and allows crud operations on users.
 */
public interface UserRepository extends CrudRepository<User, Integer> {
}
