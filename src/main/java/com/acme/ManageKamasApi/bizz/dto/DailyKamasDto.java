package com.acme.ManageKamasApi.bizz.dto;

import com.sun.istack.Nullable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
public class DailyKamasDto implements Serializable {
    @Getter
    @Setter
    @Id
    @Nullable
    private long id;
    @Getter
    @Setter
    @Nullable
    private LocalDate entryDate;
    @Getter
    @Setter
    @Nullable
    private int amount;
    @Getter
    @Setter
    @Nullable
    private DungeonDto dungeonDto;

    /**
     * Default constructor.
     * @param id            id
     * @param entryDate     entryDate
     */
    public DailyKamasDto(int id, LocalDate entryDate, int amount) {
        this.id = id;
        this.entryDate = entryDate;
        this.amount = amount;
    }
}
