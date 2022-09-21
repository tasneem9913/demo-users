package com.user.service;

import com.user.dto.UserDto;
import org.springframework.stereotype.Service;


import java.math.BigInteger;
import java.util.List;


public interface UserService {
    public BigInteger saveUser(UserDto user);

    public BigInteger updateUser(Integer id, UserDto user);

    public UserDto retrieveUser(Integer id);
    public List<UserDto> retrieveUsers();

    public Boolean deleteUser(Integer id);


}
