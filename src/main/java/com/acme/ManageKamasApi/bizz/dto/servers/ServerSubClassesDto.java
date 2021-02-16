package com.acme.ManageKamasApi.bizz.dto.servers;

import com.acme.ManageKamasApi.bizz.dto.dungeons.DungeonSubClassesDto;
import com.sun.istack.Nullable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class ServerSubClassesDto extends AbstractServerDto {
    @Getter
    @Setter
    @Nullable
    private List<DungeonSubClassesDto> dungeons;
}
