package com.acme.ManageKamasApi.bizz.controllers;

import com.acme.ManageKamasApi.bizz.dto.UserDto;
import com.acme.ManageKamasApi.dal.dao.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * User Controller.
 */
@RestController
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private IUserService userService;

    /**
     * Get the users.
     * @return the list of users
     */
    @GetMapping("get_users")
    public List<UserDto> getUsers() {
        return userService.findAll();
    }
}
