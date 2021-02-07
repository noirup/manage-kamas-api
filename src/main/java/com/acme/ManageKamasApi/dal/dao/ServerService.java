package com.acme.ManageKamasApi.dal.dao;

import com.acme.ManageKamasApi.bizz.dto.ServerDto;
import com.acme.ManageKamasApi.dal.models.Server;
import com.acme.ManageKamasApi.dal.models.User;
import com.acme.ManageKamasApi.dal.repositories.ServerRepository;
import com.acme.ManageKamasApi.dal.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ServerService extends AbstractService implements IServerService {
    @Autowired
    ServerRepository serverRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<ServerDto> getAllServers() {
        User user = getCurrentUser();
        List<ServerDto> servers = new ArrayList<>();
        user.getServers().forEach(s -> servers.add(modelMapper.map(s, ServerDto.class)));
        return servers;
    }

    @Override
    public boolean addServer(ServerDto serverDto) {
        User user = getCurrentUser();
        Server server = modelMapper.map(serverDto, Server.class);
        Server newServer = serverRepository.findByServerName(server.getServerName());
        if (Objects.isNull(newServer)) {
            newServer = serverRepository.save(server);
        }
        if (Objects.isNull(newServer.getUsers())) {
            Set<User> users = new HashSet<User>();
            users.add(user);
            newServer.setUsers(users);
        }
        if (Objects.isNull(user.getServers())) {
            Set<Server> servers = new HashSet<Server>();
            servers.add(newServer);
            user.setServers(servers);
        }
        newServer.getUsers().add(user);
        user.getServers().add(newServer);
        userRepository.save(user);
        return true;
    }
}
