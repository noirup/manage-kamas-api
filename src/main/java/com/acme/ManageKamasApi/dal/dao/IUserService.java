package com.acme.ManageKamasApi.dal.dao;

import com.acme.ManageKamasApi.bizz.dto.UserDto;
import com.acme.ManageKamasApi.bizz.dto.JwtUserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {

    List<UserDto> findAll();

    UserDto registerNewUser(UserDto user);
}
