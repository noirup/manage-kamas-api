package com.acme.ManageKamasApi.dal.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "dungeons", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
public class Dungeon {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @Getter
    @Setter
    @Column(name = "dungeon_name")
    private String dungeonName;
    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="server_id", nullable=false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Server server;
    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id", nullable=false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;
    @Getter
    @Setter
    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "dungeon")
    private List<DailyKamas> dailyKamasList;

    /**
     * Default constructor.
     * @param id            id
     * @param dungeonName   dungeonName
     * @param server        server
     * @param user          user
     */
    public Dungeon(int id, String dungeonName, Server server, User user) {
        this.id = id;
        this.dungeonName = dungeonName;
        this.server = server;
        this.user = user;
    }
}
