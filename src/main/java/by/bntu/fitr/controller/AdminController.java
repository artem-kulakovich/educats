package by.bntu.fitr.controller;


import by.bntu.fitr.constant.Constant;
import by.bntu.fitr.entity.Group;
import by.bntu.fitr.entity.Role;
import by.bntu.fitr.entity.User;
import by.bntu.fitr.repository.GroupRepository;
import by.bntu.fitr.service.GroupService;
import by.bntu.fitr.service.UserService;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;

    private final GroupService groupService;

    @Autowired
    public AdminController(UserService userService, GroupService groupService) {
        this.userService = userService;
        this.groupService = groupService;
    }

    @GetMapping("/panel")
    public String getAdminForm(Model model) {
        model.addAttribute("userList", userService.findUserByEnabledStatus(Constant.WAITING));
        return "admin/admin";
    }

    @GetMapping("/user-info/{id}")
    public String getUserById(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.findUserById(id));
        return "admin/user-info";
    }

    @GetMapping("/edit-role")
    public String getEditRoleForm(@RequestParam(value = "userId", required = false) long id, Model model) {
        model.addAttribute("user", userService.findUserById(id));
        return "admin/edit-role";
    }

    @PostMapping("/edit-role")
    public String editRole(@RequestParam("role") String role, @RequestParam("userId") long userId) {
        User user = userService.findUserById(userId);

        if (user != null && !user.getRole().getName().equals(Constant.ROLE_ADMIN)) {
            userService.updateUserRole(role, user);
        }

        return "redirect:/admin/user-info/" + userId;
    }

    @PostMapping("/add-user")
    public String addUser(@RequestParam("userId") long id) {

        User user = userService.findUserById(id);

        if (user != null) {
            userService.updateUserStatus(user, Constant.ACTIVE);
        }

        return "redirect:/admin/panel";
    }

    @GetMapping("/create-group")
    public String getCreateGroupForm(Model model) {
        model.addAttribute("group", new Group());
        return "/admin/create-group";
    }

    @PostMapping("/create-group")
    public String createGroup(@Valid @ModelAttribute("group") Group group, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "redirect:/admin/create-group";
        }

        groupService.createGroup(group);
        return "redirect:/admin/panel";
    }

    @GetMapping("/add-user-to-group")
    public String getAllGroup(Model model) {
        model.addAttribute("groupList", groupService.getAllGroups());
        return "/admin/group";

    }

    @GetMapping("/add-user-to-group/{id}")
    public String getGroup(@PathVariable("id") int id, Model model) {

        Group group = groupService.findGroupById(id);

        if(group==null){
            return "redirect:/admin/add-user-to-group";
        }

        model.addAttribute("userList",userService.getUsersByStatusAndGroup(Constant.ACTIVE));
        model.addAttribute("group",groupService.findGroupById(id));
        return "/admin/add-user-to-group";
    }

    @PostMapping("/add-user-to-group")
    public String addUserToGroup(@RequestParam("groupId") int groupId,@RequestParam("userId") int userId){
        userService.addUserToGroup(groupId,userId);
        return "redirect:/admin/add-user-to-group/"+groupId;
    }
}
