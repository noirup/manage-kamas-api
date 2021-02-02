package com.acme.ManageKamasApi.bizz.controllers;

import com.acme.ManageKamasApi.bizz.dto.UserDto;
import com.acme.ManageKamasApi.dal.dao.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

/**
 * User Controller.
 */
@CrossOrigin(origins = {"http://localhost:3000/", "https://manage-kamas.herokuapp.com/"})
@RestController
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody UserDto user) {

        UserDto newUser = userService.registerNewUser(user);

        return Objects.nonNull(newUser) ? ResponseEntity.ok(newUser) : ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    /**
     * Get the users.
     * @return the list of users
     */
    @GetMapping("get_users")
    public List<UserDto> getUsers() {
        return userService.findAll();
    }
}
