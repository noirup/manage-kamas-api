package com.acme.ManageKamasApi.dal.dao;

import com.acme.ManageKamasApi.bizz.dto.ServerDto;
import com.acme.ManageKamasApi.dal.models.User;

import java.util.List;

public interface IServerService {

    public List<ServerDto> getAllServers();

    public boolean addServer(ServerDto serverDto);
}
