package com.acme.ManageKamasApi.dal.dao;

import com.acme.ManageKamasApi.bizz.dto.servers.ServerSubClassesDto;
import com.acme.ManageKamasApi.bizz.dto.servers.ServerDto;
import com.acme.ManageKamasApi.dal.models.Server;
import com.acme.ManageKamasApi.dal.models.User;
import com.acme.ManageKamasApi.dal.repositories.DungeonRepository;
import com.acme.ManageKamasApi.dal.repositories.ServerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import static java.util.stream.Collectors.toList;

/**
 * Server service.
 */
@Service
public class ServerService extends AbstractService implements IServerService {
    @Autowired
    ServerRepository serverRepository;
    @Autowired
    DungeonRepository dungeonRepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<ServerDto> getAllServers() {
        return getCurrentUser().getServers().stream().map(s -> modelMapper.map(s, ServerDto.class)).collect(toList());
    }

    @Override
    public List<ServerSubClassesDto> getServListWithSubObjects() {
        User currentUser = getCurrentUser();
        List<Server> servers = currentUser.getServers();
        for (Server s : servers) {
            s.setDungeons(dungeonRepository.findByServerAndUserOrderByDungeonNameAsc(s, currentUser));
        }
        return servers.stream().map(s -> modelMapper.map(s, ServerSubClassesDto.class)).collect(toList());
    }

    @Override
    public ServerSubClassesDto addServer(ServerDto serverDto) {
        User user = getCurrentUser();
        Server server = modelMapper.map(serverDto, Server.class);
        Server newServer = serverRepository.findByServerName(server.getServerName());
        if (Objects.isNull(newServer)) {
            newServer = serverRepository.save(server);
        }
        if (Objects.isNull(newServer.getUsers())) {
            newServer.setUsers(new ArrayList<>());
        }
        newServer.getUsers().add(user);
        return modelMapper.map(serverRepository.save(newServer), ServerSubClassesDto.class);
    }
}
