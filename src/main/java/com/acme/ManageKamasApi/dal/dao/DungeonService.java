package com.acme.ManageKamasApi.dal.dao;

import com.acme.ManageKamasApi.bizz.dto.dungeons.DungeonDto;
import com.acme.ManageKamasApi.bizz.dto.servers.ServerDto;
import com.acme.ManageKamasApi.dal.models.Dungeon;
import com.acme.ManageKamasApi.dal.models.Server;
import com.acme.ManageKamasApi.dal.models.User;
import com.acme.ManageKamasApi.dal.repositories.DungeonRepository;
import com.acme.ManageKamasApi.dal.repositories.ServerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DungeonService extends AbstractService implements IDungeonService {
    @Autowired
    ServerRepository serverRepository;
    @Autowired
    DungeonRepository dungeonRepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<DungeonDto> getAllDungeons(ServerDto serverDto) {
        User user = getCurrentUser();
        Server server = serverRepository.findByServerName(serverDto.getServerName());
        List<DungeonDto> dungeons = new ArrayList<>();
        dungeonRepository.findByServerAndUserOrderByDungeonNameAsc(server, user)
                .forEach(d -> dungeons.add(modelMapper.map(d, DungeonDto.class)));
        return dungeons;
    }

    @Override
    public DungeonDto addDungeon(DungeonDto dungeonDto) {
        User user = getCurrentUser();
        Dungeon dungeon = modelMapper.map(dungeonDto, Dungeon.class);
        dungeon.setUser(user);
        return modelMapper.map(dungeonRepository.save(dungeon), DungeonDto.class);
    }
}
