package com.acme.ManageKamasApi.dal.dao;

import com.acme.ManageKamasApi.bizz.dto.dailykamas.DailyKamasDto;
import com.acme.ManageKamasApi.bizz.dto.dungeons.DungeonDto;
import com.acme.ManageKamasApi.dal.models.DailyKamas;
import com.acme.ManageKamasApi.dal.models.Dungeon;
import com.acme.ManageKamasApi.dal.repositories.DailyKamasRepository;
import com.acme.ManageKamasApi.dal.repositories.DungeonRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Daily kamas service
 */
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
        return dailyKamasList.stream().map(dk -> modelMapper.map(dk, DailyKamasDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<DailyKamasDto> addDailyKamas(DailyKamasDto dailyKamasDto) {
        DailyKamas dailyKamas = dailyKamasRepository.save(modelMapper.map(dailyKamasDto, DailyKamas.class));
        return Objects.nonNull(dailyKamas) ? getAllDailyKamas(dailyKamasDto.getDungeonDto()) : null;
    }

    @Override
    public void deleteDailyKamas(List<DailyKamasDto> dailyKamasDto) {
        dailyKamasDto.forEach(d -> {
            dailyKamasRepository.deleteById(d.getId());
        });
    }
}
