package com.acme.ManageKamasApi.dal.dao;

import com.acme.ManageKamasApi.bizz.dto.DungeonDto;
import com.acme.ManageKamasApi.bizz.dto.ServerDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IDungeonService {

    List<DungeonDto> getAllDungeons(ServerDto serverDto);

    boolean addDungeon(DungeonDto dungeonDto);
}
