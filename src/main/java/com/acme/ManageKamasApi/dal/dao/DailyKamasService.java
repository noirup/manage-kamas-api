package com.acme.ManageKamasApi.dal.dao;

import com.acme.ManageKamasApi.bizz.dto.DailyKamasDto;
import com.acme.ManageKamasApi.bizz.dto.DungeonDto;
import com.acme.ManageKamasApi.dal.models.DailyKamas;
import com.acme.ManageKamasApi.dal.models.Dungeon;
import com.acme.ManageKamasApi.dal.repositories.DailyKamasRepository;
import com.acme.ManageKamasApi.dal.repositories.DungeonRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class DailyKamasService implements IDailyKamasService {
    @Autowired
    DailyKamasRepository dailyKamasRepository;
    @Autowired
    DungeonRepository dungeonRepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<DailyKamasDto> getAllDailyKamas(DungeonDto dungeonDto) {
        Dungeon dungeon = dungeonRepository.findById(dungeonDto.getId()).get();
        List<DailyKamas> dailyKamasList = dailyKamasRepository.findByDungeonOrderByEntryDateDesc(dungeon);
        List<DailyKamasDto> list = new ArrayList<>();
        dailyKamasList.forEach(dk -> {
            list.add(modelMapper.map(dk, DailyKamasDto.class));
        });
        return list;
    }

    @Override
    public List<DailyKamasDto> addDailyKamas(DailyKamasDto dailyKamasDto) {
        DailyKamas dailyKamas = modelMapper.map(dailyKamasDto, DailyKamas.class);
        dailyKamas = dailyKamasRepository.save(dailyKamas);
        return Objects.nonNull(dailyKamas) ? getAllDailyKamas(dailyKamasDto.getDungeonDto()) : null;
    }
}
