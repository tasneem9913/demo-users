package com.user.dao;

import com.user.dto.UserDto;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;
import java.util.List;

public interface UserServiceDao{
    public BigInteger saveUser(UserDto user);

    public BigInteger updateUser(Integer id, UserDto user);

    public UserDto retrieveUser(Integer id);


    public List<UserDto> retrieveUsers();

    public Boolean deleteUser(Integer id);

    UserDto findByUsername(String username);



}
