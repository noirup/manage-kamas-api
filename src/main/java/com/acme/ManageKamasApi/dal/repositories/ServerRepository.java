package com.acme.ManageKamasApi.dal.repositories;

import com.acme.ManageKamasApi.dal.models.Server;
import org.springframework.data.repository.CrudRepository;

public interface ServerRepository extends CrudRepository<Server, Long> {
    Server findByServerName(String serverName);
}
