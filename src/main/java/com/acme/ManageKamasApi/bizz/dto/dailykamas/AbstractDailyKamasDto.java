package com.acme.ManageKamasApi.bizz.dto.dailykamas;

import com.sun.istack.Nullable;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import java.time.LocalDate;

public abstract class AbstractDailyKamasDto {
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
}
