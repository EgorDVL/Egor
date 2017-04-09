package zhyzhko.spring.demo.services;

import zhyzhko.spring.demo.dto.UserDto;

import java.util.List;

/**
 * Created by Egor on 24.02.2017.
 */
public interface UserService {
    UserDto createUser(UserDto userDto);

    UserDto getUser(int userId);

    UserDto getUser(String email);

    List<UserDto> getAllUsers();

    boolean updateUser(UserDto userDto);

    boolean deleteUser(int userId);

    boolean deleteUser(UserDto userDto);

    List<UserDto> getAllUsersInGroup(int groupId);
}
