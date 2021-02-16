package com.acme.ManageKamasApi.bizz.controllers;

import com.acme.ManageKamasApi.bizz.dto.dailykamas.DailyKamasDto;
import com.acme.ManageKamasApi.bizz.dto.dungeons.DungeonDto;
import com.acme.ManageKamasApi.dal.dao.IDailyKamasService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

//@CrossOrigin(origins = {"http://localhost:3000", "https://manage-kamas.herokuapp.com/"})
@RestController
@RequestMapping("/daily_kamas/")
public class DailyKamasController {
    @Autowired
    private IDailyKamasService dailyKamasService;
    @Autowired
    ModelMapper modelMapper;

    @PostMapping("/get_all_by_dungeon")
    public List<DailyKamasDto> getAllDailyKamas(@RequestBody DungeonDto dungeonDto) {
        return dailyKamasService.getAllDailyKamas(dungeonDto);
    }

    @PostMapping("/add_daily_kamas")
    public ResponseEntity<?> addDailyKamas(@RequestBody DailyKamasDto dailyKamasDto) {
        List<DailyKamasDto> dailyKamas = dailyKamasService.addDailyKamas(dailyKamasDto);
        return Objects.nonNull(dailyKamas) ?
                ResponseEntity.ok(dailyKamas) : ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping("/delete_daily_kamas")
    public ResponseEntity<?> deleteDailyKamas(@RequestBody List<DailyKamasDto> dailyKamasDtos) {
        dailyKamasService.deleteDailyKamas(dailyKamasDtos);
        return ResponseEntity.ok(dailyKamasService.getAllDailyKamas(dailyKamasDtos.stream()
                .filter(d -> Objects.nonNull(d.getDungeonDto())).findFirst().get().getDungeonDto()));
    }
}
