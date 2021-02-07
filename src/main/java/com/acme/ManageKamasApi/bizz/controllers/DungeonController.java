package com.acme.ManageKamasApi.bizz.controllers;

import com.acme.ManageKamasApi.bizz.dto.DungeonDto;
import com.acme.ManageKamasApi.bizz.dto.ServerDto;
import com.acme.ManageKamasApi.dal.dao.IDungeonService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = {"http://localhost:3000", "https://manage-kamas.herokuapp.com/login"})
@RestController
@RequestMapping("/dungeon/")
public class DungeonController {
    @Autowired
    private IDungeonService dungeonService;
    @Autowired
    ModelMapper modelMapper;

    @GetMapping("/get_dungeons")
    public List<DungeonDto> getDungeonList(@RequestBody ServerDto serverDto) {
        return dungeonService.getAllDungeons(serverDto);
    }

    @PostMapping("/add_dungeon")
    public ResponseEntity<?> addDungeon(@RequestBody DungeonDto dungeonDto) {
        return dungeonService.addDungeon(dungeonDto) ?
                ResponseEntity.ok(dungeonService.getAllDungeons(modelMapper.map(dungeonDto.getServer(), ServerDto.class)))
                : ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}
