package com.acme.ManageKamasApi.bizz.dto;

import com.sun.istack.Nullable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    @Getter
    @Setter
    @Id
    @Nullable
    private long id;
    @Getter
    @Setter
    @Nullable
    private String login;
    @Getter
    @Setter
    @Nullable
    private String email;
    @Getter
    @Setter
    @Nullable
    private String password;

    /**
     * Default constructor.
     * @param id        id
     * @param login     login
     * @param email     email
     * @param password  password
     */
    public UserDto(int id, String login, String email, String password) {
        this.id = id;
        this.login = login;
        this.email = email;
        this.password = password;
    }
}