package com.acme.ManageKamasApi.dal.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * User Entity.
 */
@Entity
@Table(name = "users", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @Getter
    @Setter
    @Column(name = "login")
    private String login;
    @Getter
    @Setter
    @Column(name="email")
    private String email;
    @Getter
    @Setter
    @Column(name = "password")
    private String password;
    @Getter
    @Setter
    @ManyToMany(fetch = FetchType.LAZY,
            mappedBy = "users")
    private List<Server> servers;
    @Getter
    @Setter
    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "user")
    private List<Dungeon> dungeons;

    /**
     * Default constructor.
     * @param id        id
     * @param login     login
     * @param email     email
     * @param password  password
     * @param servers   servers
     */
    public User(int id, String login, String email, String password, List<Server> servers) {
        this.id = id;
        this.login = login;
        this.email = email;
        this.password = password;
        this.servers = servers;
    }
}
