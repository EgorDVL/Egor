package zhyzhko.spring.demo.dao.jdbc.rowMapper;

import org.springframework.jdbc.core.RowMapper;
import zhyzhko.spring.demo.dto.GroupDto;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Egor on 24.02.2017.
 */
public class GroupRowMapper implements RowMapper<GroupDto> {

    @Override
    public GroupDto mapRow(ResultSet set, int rowNum) throws SQLException {
        GroupDto groupDto = new GroupDto();
        groupDto.setId(set.getInt(1));
        groupDto.setName(set.getString(2));
        groupDto.setCountStudents(set.getInt(3));
        return groupDto;
    }

}
