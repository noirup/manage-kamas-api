package com.acme.ManageKamasApi.dal.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * User Entity.
 */
@Entity
@Table(name = "user", schema = "public")
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

    /**
     * Default constructor.
     * @param id        id
     * @param login     login
     * @param email     email
     * @param password  password
     */
    public User(int id, String login, String email, String password) {
        this.id = id;
        this.login = login;
        this.email = email;
        this.password = password;
    }
}
