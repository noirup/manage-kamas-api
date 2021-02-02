package com.acme.ManageKamasApi.dal.dao;

import com.acme.ManageKamasApi.bizz.dto.UserDto;

import java.util.List;

public interface IUserService {

    List<UserDto> findAll();

    UserDto registerNewUser(UserDto user);
}
