package com.acme.ManageKamasApi.bizz.controllers;

import com.acme.ManageKamasApi.bizz.dto.dungeons.DungeonDto;
import com.acme.ManageKamasApi.bizz.dto.servers.ServerDto;
import com.acme.ManageKamasApi.dal.dao.IDungeonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = {"http://localhost:3000", "https://manage-kamas.herokuapp.com/"})
@RestController
@RequestMapping("/dungeon/")
public class DungeonController {
    @Autowired
    private IDungeonService dungeonService;

    @PostMapping("/get_dungeons")
    public List<DungeonDto> getDungeonList(@RequestBody ServerDto serverDto) {
        return dungeonService.getAllDungeons(serverDto);
    }

    @PostMapping("/add_dungeon")
    public ResponseEntity<?> addDungeon(@RequestBody DungeonDto dungeonDto) {
        return ResponseEntity.ok(dungeonService.addDungeon(dungeonDto));
    }

    @DeleteMapping("/delete_dungeon")
    public ResponseEntity<?> deleteDungeon(@RequestBody DungeonDto dungeonDto) {
        return ResponseEntity.ok(dungeonService.deleteDungeon(dungeonDto));
    }
}
