package zhyzhko.spring.demo.dao;

import zhyzhko.spring.demo.dao.entity.User;

import java.util.List;

/**
 * Created by Egor on 24.02.2017.
 */
public interface UserDao {
    User createUser(User user);

    User getUser(int userId);

    User getUser(String email);

    List<User> getAllUsers();

    boolean updateUser(User user);

    boolean deleteUser(int userId);

    boolean deleteUser(User user);


    List<User> getAllUsersInGroup(int groupId);

//    int createUser(UserDto user);
//
//    UserDto getUser(int userId);
//
//    List<UserDto> getAllUsers();
//
//    boolean updateUser(UserDto user);
//
//    boolean deleteUser(int userId);
//
//    List<UserDto> getAllUsersInGroup(int groupId);
}
