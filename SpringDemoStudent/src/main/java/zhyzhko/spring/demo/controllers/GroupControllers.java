package zhyzhko.spring.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import zhyzhko.spring.demo.dto.GroupDto;
import zhyzhko.spring.demo.services.GroupService;
import zhyzhko.spring.demo.services.UserService;

/**
 * Created by Egor on 27.02.2017.
 */
@Controller
public class GroupControllers {
    @Autowired
    private GroupService groupService;

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/useradmin/ShowAllGroups", method = RequestMethod.GET)
    public String getAllGroups(Model model) {
        model.addAttribute("groupps", groupService.getAllGroups());
        return "show-all-groups";
    }

    @RequestMapping(value = "/admin/CreateGroupPage")
    public String createGroupPage() {
        return "create-group";
    }

    @RequestMapping(value = "/CreateGroup", method = RequestMethod.POST)
    public String createGroup(GroupDto groupDto) {
        groupService.createGroup(groupDto);
        return "main";
    }

    @RequestMapping(value = "/UpdateGroupPage")
    public String updateGroupPage(@RequestParam int groupId, Model model) {
        model.addAttribute("group", groupService.getGroup(groupId));
        return "update-group";
    }

    @RequestMapping(value = "/UpdateGroup", method = RequestMethod.POST)
    public String updateGroup(GroupDto groupDto) {
        groupService.updateGroup(groupDto);
        return "main";
    }


    @RequestMapping(value = "/GetGroup", method = RequestMethod.GET)
    public String getGroupById(@RequestParam int id, Model model) {
        model.addAttribute("group", groupService.getGroup(id));
        return "show-group";
    }

    @RequestMapping(value = "/DeleteGroup", method = RequestMethod.POST)
    public String deleteGroup(@RequestParam int id) {
        groupService.deleteGroup(id);
        return "main";
    }

    @RequestMapping(value = "/ShowAllUsersInGroup", method = RequestMethod.GET)
    public String showAllUsersInGroup(@RequestParam int groupId, Model model) {
        model.addAttribute("users", userService.getAllUsersInGroup(groupId));
        return "show-all-users";
    }
}
