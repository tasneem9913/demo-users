package com.user.dao.impl;

import com.user.dao.UserServiceDao;
import com.user.dto.UserDto;


import com.user.row.mapper.UserDetailsRowMapper;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public  class UserServiceDaoImpl implements UserServiceDao {

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public BigInteger saveUser(UserDto user) {

        try {
            String sql = "insert into users "
                    + "(name" + ") "
                    + "values (?) ";

            KeyHolder holder = new GeneratedKeyHolder();
            jdbcTemplate.update(new PreparedStatementCreator() {

                @Override
                public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                    PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                    ps.setString(1, user.getName());


                    return ps;
                }

            }, holder);
            return BigInteger.valueOf((Long) holder.getKeys().get("id"));

        } catch (Exception e) {
        log.error(String.valueOf(e));}
        return null;


    }

        @Override
    public BigInteger updateUser(Integer id, UserDto user) {

            final String sql = "UPDATE users SET name =? where id=?";

        Integer result = jdbcTemplate.update(sql, user.getName(), id);
        return BigInteger.valueOf(result);


    }

    @Override
    public UserDto retrieveUser(Integer id) {
        UserDto userDtos = null;

            String sql = "SELECT * from users where id=('" + id + "')";

            userDtos = jdbcTemplate.queryForObject(sql, new UserDetailsRowMapper());
            return userDtos;

    }


    @Override
    public List<UserDto> retrieveUsers() {
        List<UserDto> userDtos = null;
            String sql = "SELECT * from users ";
            userDtos = jdbcTemplate.query(sql, new UserDetailsRowMapper());
            return userDtos;

    }

    @Override
    public Boolean deleteUser(Integer id) {

        final String sql = "DELETE users where id=?";

        Integer result = jdbcTemplate.update(sql, "SELF", LocalDateTime.now(), id);

        return result >= 1;
    }

    @Override
    public UserDto findByUsername(String username) {
        return null;
    }

}
