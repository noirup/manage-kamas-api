package com.acme.ManageKamasApi.bizz.dto.dungeons;

import com.acme.ManageKamasApi.bizz.dto.servers.ServerDto;
import com.sun.istack.Nullable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class DungeonDto extends AbstractDungeonDto {
    @Getter
    @Setter
    @Nullable
    private ServerDto server;
}
