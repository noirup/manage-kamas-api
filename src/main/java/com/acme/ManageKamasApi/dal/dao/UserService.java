package com.acme.ManageKamasApi.dal.dao;

import com.acme.ManageKamasApi.bizz.dto.UserDto;
import com.acme.ManageKamasApi.dal.repositories.UserRepository;
import com.acme.ManageKamasApi.dal.models.User;
import com.acme.ManageKamasApi.bizz.dto.JwtUserDetails;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    private PasswordEncoder passwordEncoderBean;

    @Override
    public List<UserDto> findAll() {
        List<UserDto> users = new ArrayList<>();
        List<User> userList = (List<User>) userRepository.findAll();
        for (User u : userList) {
            users.add(modelMapper.map(u, UserDto.class));
        }
        return users;
    }

    @Override
    public UserDto registerNewUser(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        if (userExist(user.getLogin())) {
            return null;
        }
        user.setPassword(passwordEncoderBean.encode(userDto.getPassword()));
        user = userRepository.save(user);
        user.setPassword(userDto.getPassword());
        return modelMapper.map(user, UserDto.class);
    }

    private boolean userExist(String login) {
        return userRepository.findByLogin(login) != null;
    }


    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userRepository.findByLogin(login);
        return new JwtUserDetails(user.getId(), user.getLogin(), user.getPassword(), "ROLE_USER_2");
    }
}
