package com.user.service.impl;



import com.user.dao.UserServiceDao;
import com.user.dto.UserDto;
import com.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

@Service(value = "userService")

public class UserServiceImpl implements UserService  {

    @Autowired
    UserServiceDao userServiceDao;


    @Override
    public BigInteger saveUser(UserDto user) {
        return userServiceDao.saveUser( user);

    }



    @Override
    public BigInteger updateUser(Integer id, UserDto user) {


        return userServiceDao.updateUser(id, user);
    }

    @Override
    public UserDto retrieveUser(Integer id) {


        return userServiceDao.retrieveUser(id);

    }
    @Override
    public List<UserDto> retrieveUsers() {


        return userServiceDao.retrieveUsers();

    }

    @Override
    public Boolean deleteUser(Integer id) {

        return userServiceDao.deleteUser(id);
            }


}


