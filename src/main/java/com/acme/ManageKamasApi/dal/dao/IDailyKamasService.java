package com.acme.ManageKamasApi.dal.dao;

import com.acme.ManageKamasApi.bizz.dto.DailyKamasDto;
import com.acme.ManageKamasApi.bizz.dto.DungeonDto;

import java.util.List;

public interface IDailyKamasService {
    List<DailyKamasDto> getAllDailyKamas(DungeonDto dungeonDto);

    List<DailyKamasDto> addDailyKamas(DailyKamasDto dailyKamasDto);
}
