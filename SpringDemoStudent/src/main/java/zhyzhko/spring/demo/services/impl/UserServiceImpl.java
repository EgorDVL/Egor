package zhyzhko.spring.demo.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zhyzhko.spring.demo.dao.GroupDao;
import zhyzhko.spring.demo.dao.UserDao;
import zhyzhko.spring.demo.dao.entity.Groupp;
import zhyzhko.spring.demo.dao.entity.User;
import zhyzhko.spring.demo.dto.UserDto;
import zhyzhko.spring.demo.services.UserService;
import zhyzhko.spring.demo.until.UserConvertor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Egor on 24.02.2017.
 */
@Service
public class UserServiceImpl implements UserService {
    private UserDao userDao;
    private GroupDao groupDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserConvertor userConvertor;

    @Autowired
    public UserServiceImpl(UserDao userDao, GroupDao groupDao) {
        this.userDao = userDao;
        this.groupDao = groupDao;
    }

    @Transactional
    @Override
    public UserDto createUser(UserDto userDto) {
        User user = userConvertor.convertToEntity(userDto);


        Groupp groupp = groupDao.getGroup(userDto.getGroupId());
        groupp.setCountStudents(groupp.getCountStudents() + 1);
        groupDao.updateGroup(groupp);

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userConvertor.convertToDto(userDao.createUser(user));
    }


    @Transactional
    @Override
    public UserDto getUser(int userId) {
        return userConvertor.convertToDto(userDao.getUser(userId));
    }

    @Transactional
    @Override
    public UserDto getUser(String email) {
        return userConvertor.convertToDto(userDao.getUser(email));
    }


    @Transactional
    @Override
    public List<UserDto> getAllUsers() {
        return mapUserListToDto(userDao.getAllUsers());
    }

    @Transactional
    @Override
    public boolean updateUser(UserDto userDto) {
        User user = userConvertor.convertToEntity(userDto);
        return userDao.updateUser(user);
    }

    @Transactional
    @Override
    public boolean deleteUser(int userId) {
        return userDao.deleteUser(userId);
    }

    @Transactional
    @Override
    public boolean deleteUser(UserDto userDto) {
        User user = userConvertor.convertToEntity(userDto);
        return userDao.deleteUser(user);
    }

    @Transactional
    @Override
    public List<UserDto> getAllUsersInGroup(int groupId) {
//        return userDao.getAllUsersInGroup(groupId);
        return mapUserListToDto(userDao.getAllUsersInGroup(groupId));
    }

    private List<UserDto> mapUserListToDto(List<User> users) {
//        List<UserDto> userDtoList = new ArrayList<>();
//        for (User user : users) {
//            userDtoList.add(userConvertor.convertToDto(user));
//        }
        return users
                .stream()
                .map(userConvertor::convertToDto)
                .collect(Collectors.toList());
    }
}
