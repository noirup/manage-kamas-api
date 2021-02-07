package com.acme.ManageKamasApi.dal.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

/**
 * Server entity.
 */
@Entity
@Table(name = "servers", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
public class Server {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @Getter
    @Setter
    @Column(name = "server_name")
    private String serverName;
    @Getter
    @Setter
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "servers")
    private Set<User> users;

    /**
     * Default constructor.
     * @param id        id
     * @param serverName     server name
     */
    public Server(int id, String serverName) {
        this.id = id;
        this.serverName = serverName;
    }

    /**
     * Default constructor.
     * @param id        id
     * @param serverName     server name
     * @param users     users
     */
    public Server(int id, String serverName, Set<User> users) {
        this.id = id;
        this.serverName = serverName;
        this.users = users;
    }
}
