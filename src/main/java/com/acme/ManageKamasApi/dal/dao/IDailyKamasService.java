package com.acme.ManageKamasApi.dal.dao;

import com.acme.ManageKamasApi.bizz.dto.dailykamas.DailyKamasDto;
import com.acme.ManageKamasApi.bizz.dto.dungeons.DungeonDto;

import java.util.List;

public interface IDailyKamasService {
    List<DailyKamasDto> getAllDailyKamas(DungeonDto dungeonDto);

    List<DailyKamasDto> addDailyKamas(DailyKamasDto dailyKamasDto);

    void deleteDailyKamas(List<DailyKamasDto> dailyKamasDto);
}
