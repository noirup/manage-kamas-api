package com.acme.ManageKamasApi.dal.repositories;

import com.acme.ManageKamasApi.dal.models.Dungeon;
import com.acme.ManageKamasApi.dal.models.Server;
import com.acme.ManageKamasApi.dal.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DungeonRepository extends CrudRepository<Dungeon, Long> {
    List<Dungeon> findByServerAndUser(Server server, User user);
}
