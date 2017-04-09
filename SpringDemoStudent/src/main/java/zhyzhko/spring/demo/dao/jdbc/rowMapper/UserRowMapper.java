package zhyzhko.spring.demo.dao.jdbc.rowMapper;


import org.springframework.jdbc.core.RowMapper;
import zhyzhko.spring.demo.dto.UserDto;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Egor on 24.02.2017.
 */
public class UserRowMapper implements RowMapper<UserDto> {


    @Override
    public UserDto mapRow(ResultSet set, int rowNum) throws SQLException {
        UserDto userDto = new UserDto();
//        userDto.setId(set.getInt(1));
//        userDto.setEmail(set.getString(2));
//        userDto.setPassword(set.getString(3));
//        userDto.setName(set.getString(4));
//        userDto.setSurname(set.getString(5));
//        userDto.setRoleDto(RoleDto.fromValue(set.getInt(6)));
//        userDto.setGroupId(set.getInt(7));
        return userDto;
    }
}
