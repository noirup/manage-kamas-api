package com.acme.ManageKamasApi.dal.dao;

import com.acme.ManageKamasApi.bizz.dto.servers.ServerSubClassesDto;
import com.acme.ManageKamasApi.bizz.dto.servers.ServerDto;

import java.util.List;

public interface IServerService {

    List<ServerDto> getAllServers();

    ServerSubClassesDto addServer(ServerDto serverDto);

    List<ServerSubClassesDto> getServListWithSubObjects();
}
