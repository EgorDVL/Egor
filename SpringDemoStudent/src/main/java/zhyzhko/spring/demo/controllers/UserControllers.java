package zhyzhko.spring.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import zhyzhko.spring.demo.dao.entity.enums.RoleEnum;
import zhyzhko.spring.demo.dto.GroupDto;
import zhyzhko.spring.demo.dto.UserDto;
import zhyzhko.spring.demo.services.GroupService;
import zhyzhko.spring.demo.services.MailSenderService;
import zhyzhko.spring.demo.services.UserService;

import javax.validation.Valid;
import java.util.*;

/**
 * Created by Egor on 26.02.2017.
 */
@Controller
public class UserControllers {

    @Autowired
    private UserService userService;

    @Autowired
    private GroupService groupService;

    @Autowired
    private MailSenderService mailSenderService;

    //Show all users
    @RequestMapping(value = "/useradmin/ShowAllUsers", method = RequestMethod.GET)
    public String showAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "show-all-users";
    }
    //Show all users another method
//    @RequestMapping(value = "/showAllUsers", method = RequestMethod.GET)
//    public ModelAndView showAllUsers(ModelAndView modelAndView) {
//        modelAndView.setViewName("show-all-users");
//        modelAndView.addObject("users", userService.getAllUsers());
//        return modelAndView;
//    }

    //Get user by id
    @RequestMapping(value = "/GetById", method = RequestMethod.POST)
    public String getById(@RequestParam int id, Model model) {
        UserDto userDto = userService.getUser(id);
        model.addAttribute("user", userDto);
        return "show-user";
    }

    //Get user by email
    @RequestMapping(value = "/GetByEmail", method = RequestMethod.POST)
    public String getByEmail(@RequestParam String email, Model model) {
        UserDto userDto = userService.getUser(email);
        model.addAttribute("user", userDto);
        return "show-user";
    }

    //Redirect to create user page
    @RequestMapping(value = "/admin/CreateUserPage", method = RequestMethod.GET)
    public String pageCreateUser(Model model) {
        getAllGroupsModel(model);
        model.addAttribute("userDto", new UserDto());
        return "create-user";
    }

    //Create userDto
    @RequestMapping(value = "/CreateUser", method = RequestMethod.POST)
    public String createUser(@Valid UserDto userDto,
                             BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            getAllGroupsModel(model);
            return "create-user";
        }
        userService.createUser(userDto);
        mailSenderService.sendEmail(userDto);
        return "main";
    }


    private void getAllGroupsModel(Model model) {
        List<GroupDto> groupDtoList = groupService.getAllGroups();
        Map<Integer, String> groupMap = new HashMap<>();
        for (GroupDto groupDto : groupDtoList) {
            groupMap.put(groupDto.getId(), groupDto.getName());
        }
        model.addAttribute("groupMap", groupMap);
    }

    //Delete user
    @RequestMapping(value = "/DeleteUser", method = RequestMethod.POST)
    public String deleteUser(@RequestParam int id) {
        userService.deleteUser(id);
        return "main";
    }

    //Redirect to update user page
    @RequestMapping(value = "/UpdateUserPage")
    public String pageUpdateUser(@RequestParam int userId, Model model) {
        model.addAttribute("user", userService.getUser(userId));
        return "update-user";
    }

    //Update user
    @RequestMapping(value = "/UpdateUser", method = RequestMethod.POST)
    public String updateUser(UserDto userDto) {
        userService.updateUser(userDto);
        return "main";
    }
}