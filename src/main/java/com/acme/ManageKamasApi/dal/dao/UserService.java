package com.acme.ManageKamasApi.dal.dao;

import com.acme.ManageKamasApi.bizz.dto.UserDto;
import com.acme.ManageKamasApi.dal.repositories.UserRepository;
import com.acme.ManageKamasApi.dal.models.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService{
    @Autowired
    UserRepository userRepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<UserDto> findAll() {
        List<UserDto> users = new ArrayList<>();
        List<User> userList = (List<User>) userRepository.findAll();
        for (User u : userList) {
            users.add(modelMapper.map(u, UserDto.class));
        }
        return users;
    }
}
