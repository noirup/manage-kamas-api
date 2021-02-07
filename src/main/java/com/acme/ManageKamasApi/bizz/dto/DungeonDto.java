package com.acme.ManageKamasApi.bizz.dto;

import com.acme.ManageKamasApi.dal.models.Server;
import com.acme.ManageKamasApi.dal.models.User;
import com.sun.istack.Nullable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Id;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
public class DungeonDto implements Serializable {
    @Getter
    @Setter
    @Id
    @Nullable
    private long id;
    @Getter
    @Setter
    @Nullable
    private String dungeonName;
    @Getter
    @Setter
    @Nullable
    private ServerDto server;

    /**
     * Default constructor.
     * @param id            id
     * @param dungeonName   dungeonName
     */
    public DungeonDto(int id, String dungeonName) {
        this.id = id;
        this.dungeonName = dungeonName;
    }
}
