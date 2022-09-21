package com.user.row.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.user.dto.UserDto;
import org.springframework.jdbc.core.RowMapper;


public class UserDetailsRowMapper implements RowMapper<UserDto> {

    @Override
    public UserDto mapRow(ResultSet rs, int rowNum) throws SQLException {
    	UserDto response = new UserDto();
        response.setName(rs.getString("name"));
        return response;
    }
}
