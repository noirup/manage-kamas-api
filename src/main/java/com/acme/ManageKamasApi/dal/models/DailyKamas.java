package com.acme.ManageKamasApi.dal.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "daily_kamas", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
public class DailyKamas {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @Getter
    @Setter
    @Column(name = "entry_date")
    private LocalDate entryDate;
    @Getter
    @Setter
    @Column(name = "amount")
    private int amount;
    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="dungeon_id", nullable=false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Dungeon dungeon;

    /**
     * Default constructor.
     * @param id            id
     * @param entryDate     entryDate
     */
    public DailyKamas(int id, LocalDate entryDate, int amount) {
        this.id = id;
        this.entryDate = entryDate;
        this.amount = amount;
    }
}
