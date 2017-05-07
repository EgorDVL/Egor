package zhyzhko.spring.demo.dao.jdbc;


import org.springframework.stereotype.Repository;

/**
 * Created by Egor on 24.02.2017.
 */
@Repository
public class GroupDaoImpl
//        implements GroupDao
{

//    private static final String CREATE_GROUP = "insert into `group` values(default, ?, ?)";
//    private static final String GET_GROUP = "select * from `group` where id = ?";
//    private static final String GET_ALL_GROUP = "select * from `group`";
//    private static final String UPDATE_GROUP = "update `group` set name = ?, countStudents = ? where id = ?";
//    private static final String DELETE_GROUP = "delete from `group` where id = ?";

//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//
//    @Override
//    public int createGroup(GroupDto group) {
//        return jdbcTemplate.update(CREATE_GROUP, group.getName(), group.getCountStudents());
//    }
//
//    @Override
//    public GroupDto getGroup(int groupId) {
//        return jdbcTemplate.queryForObject(GET_GROUP, new GroupRowMapper(), groupId);
//    }
//
//    @Override
//    public List<GroupDto> getAllGroups() {
//        return jdbcTemplate.query(GET_ALL_GROUP, new GroupRowMapper());
//    }
//
//    @Override
//    public boolean updateGroup(GroupDto group) {
//        return jdbcTemplate.update(UPDATE_GROUP, group.getName(), group.getCountStudents(), group.getId()) > 0;
//    }
//
//    @Override
//    public boolean deleteGroup(int groupId) {
//        return jdbcTemplate.update(DELETE_GROUP, groupId) > 0;
//    }
}
