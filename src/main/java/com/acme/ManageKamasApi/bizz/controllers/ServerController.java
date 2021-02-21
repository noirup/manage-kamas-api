package com.acme.ManageKamasApi.bizz.controllers;

import com.acme.ManageKamasApi.bizz.dto.servers.ServerSubClassesDto;
import com.acme.ManageKamasApi.bizz.dto.servers.ServerDto;
import com.acme.ManageKamasApi.dal.dao.IServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

/**
 * Server Controller.
 */
//@CrossOrigin(origins = {"http://localhost:3000", "https://manage-kamas.herokuapp.com/"})
@RestController
@RequestMapping("/server/")
public class ServerController {

    @Autowired
    private IServerService serverService;

    @GetMapping("/get_servers")
    public List<ServerDto> getServerList() {
        return serverService.getAllServers();
    }

    @GetMapping("/get_sub_classes_servers")
    public List<ServerSubClassesDto> getServListWithSubObjects() {
        return serverService.getServListWithSubObjects();
    }

    @PostMapping("/add_server")
    public ResponseEntity<?> AddServer(@RequestBody ServerDto serverDto) {
        return ResponseEntity.ok(serverService.addServer(serverDto));
    }
}
