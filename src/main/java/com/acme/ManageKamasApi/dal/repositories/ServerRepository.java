package com.acme.ManageKamasApi.dal.repositories;

import com.acme.ManageKamasApi.dal.models.Server;
import com.acme.ManageKamasApi.dal.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ServerRepository extends CrudRepository<Server, Long> {
    @Query()
    Server findByServerName(String serverName);
}
