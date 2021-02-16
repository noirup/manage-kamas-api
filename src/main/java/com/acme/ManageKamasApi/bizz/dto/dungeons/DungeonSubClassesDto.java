package com.acme.ManageKamasApi.bizz.dto.dungeons;

import com.acme.ManageKamasApi.bizz.dto.dailykamas.DailyKamasSubClassesDto;
import com.sun.istack.Nullable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class DungeonSubClassesDto extends AbstractDungeonDto {
    @Getter
    @Setter
    @Nullable
    private List<DailyKamasSubClassesDto> dailyKamas;
}
