package com.acme.ManageKamasApi.bizz.dto.dailykamas;

import com.acme.ManageKamasApi.bizz.dto.dungeons.DungeonDto;
import com.sun.istack.Nullable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class DailyKamasDto extends AbstractDailyKamasDto {
    @Getter
    @Setter
    @Nullable
    private DungeonDto dungeonDto;
}
