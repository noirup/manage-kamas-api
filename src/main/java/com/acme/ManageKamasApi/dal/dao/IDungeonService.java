package com.acme.ManageKamasApi.dal.dao;

import com.acme.ManageKamasApi.bizz.dto.dungeons.DungeonDto;
import com.acme.ManageKamasApi.bizz.dto.dungeons.DungeonSubClassesDto;
import com.acme.ManageKamasApi.bizz.dto.servers.ServerDto;

import java.util.List;

public interface IDungeonService {

    List<DungeonDto> getAllDungeons(ServerDto serverDto);

    DungeonDto addDungeon(DungeonDto dungeonDto);

    List<DungeonSubClassesDto> deleteDungeon(DungeonDto dungeon);
}
