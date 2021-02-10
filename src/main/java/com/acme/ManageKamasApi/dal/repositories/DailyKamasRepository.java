package com.acme.ManageKamasApi.dal.repositories;

import com.acme.ManageKamasApi.dal.models.DailyKamas;
import com.acme.ManageKamasApi.dal.models.Dungeon;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DailyKamasRepository extends CrudRepository<DailyKamas, Long> {
    List<DailyKamas> findByDungeonOrderByEntryDateDesc(Dungeon dungeon);
}
