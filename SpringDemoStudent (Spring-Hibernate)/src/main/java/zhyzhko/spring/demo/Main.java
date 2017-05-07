package zhyzhko.spring.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import zhyzhko.spring.demo.dao.UserDao;
import zhyzhko.spring.demo.dao.entity.enums.RoleEnum;
import zhyzhko.spring.demo.dto.GroupDto;
import zhyzhko.spring.demo.configuration.ConfigApp;
import zhyzhko.spring.demo.dto.UserDto;
import zhyzhko.spring.demo.services.GroupService;
import zhyzhko.spring.demo.services.UserService;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Egor on 24.02.2017.
 */
public class Main {
    public static void main(String[] args) {
//        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigApp.class);

//        GroupService groupService = (GroupService) context.getBean("groupServiceImpl");


//        GroupDto groupDto = new GroupDto(1, "Informatica", 13);
//        groupService.createGroup(groupDto);
//        System.out.println(groupService.getGroup(1));
//
//        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigApp.class);
//        UserService userService = context.getBean(UserService.class);
//        UserDao userDao = context.getBean(UserDao.class);

//        Set<RoleEnum> roleEnums = new HashSet<>();
//        roleEnums.add(RoleEnum.USER);
//        UserDto userDto = new UserDto(2, "EgorDVL@mail.ru", "11111", "Egor", "Pupkin", 1, roleEnums);
//        System.out.println(userService.updateUser(userDto));

//        UserDto user = userService.getUser(2);
//        System.out.println(userService.deleteUser(user));
//        System.out.println(userService.deleteUser(2));

    }
}
