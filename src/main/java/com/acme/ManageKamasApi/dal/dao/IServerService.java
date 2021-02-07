package com.acme.ManageKamasApi.dal.dao;

import com.acme.ManageKamasApi.bizz.dto.ServerDto;
import com.acme.ManageKamasApi.dal.models.User;

import java.util.List;

public interface IServerService {

    List<ServerDto> getAllServers();

    boolean addServer(ServerDto serverDto);
}
