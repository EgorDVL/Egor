package zhyzhko.spring.demo.dao.jdbc;

import org.springframework.stereotype.Repository;

/**
 * Created by Egor on 24.02.2017.
 */
@Repository
public class UserDaoImpl
//        implements UserDao
{
//    private static final String CREATE_USER = "insert into user values(default, ?, ?, ?, ?, ?, ?)";
//    private static final String GET_USER = "select * from user where id = ?";
//    private static final String GET_ALL_USER = "select * from user";
//    private static final String UPDATE_USER = "update user set email = ?, password = ?, name = ?, surname = ?, roleId = ?, groupId = ? where id = ?";
//    private static final String DELETE_USER = "delete from user where id = ?";
//    private static final String GET_ALL_USER_IN_GROUP = "select * from user where groupId = ?";
//
//
//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//
//    @Override
//    public int createUser(UserDto user) {
//        return jdbcTemplate.update(CREATE_USER, user.getEmail(), user.getPassword(), user.getName(), user.getSurname(),
//                user.getRoleDto().getValue(), user.getGroupId());
//    }
//
//    @Override
//    public UserDto getUser(int userId) {
//        return jdbcTemplate.queryForObject(GET_USER, new UserRowMapper(), userId);
//    }
//
//    @Override
//    public List<UserDto> getAllUsers() {
//        return jdbcTemplate.query(GET_ALL_USER, new UserRowMapper());
//    }
//
//    @Override
//    public boolean updateUser(UserDto user) {
//        return jdbcTemplate.update(UPDATE_USER, user.getEmail(), user.getPassword(), user.getName(), user.getSurname(),
//                user.getRoleDto().getValue(), user.getGroupId(), user.getId()) > 0;
//    }
//
//    @Override
//    public boolean deleteUser(int userId) {
//        return jdbcTemplate.update(DELETE_USER, userId) > 0;
//    }
//
//    @Override
//    public List<UserDto> getAllUsersInGroup(int groupId) {
//        return jdbcTemplate.query(GET_ALL_USER_IN_GROUP, new UserRowMapper(), groupId);
//    }
}
