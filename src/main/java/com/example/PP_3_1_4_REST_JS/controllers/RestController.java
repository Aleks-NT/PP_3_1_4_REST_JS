package com.example.PP_3_1_4_REST_JS.controllers;


import com.example.PP_3_1_4_REST_JS.model.Role;
import com.example.PP_3_1_4_REST_JS.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.example.PP_3_1_4_REST_JS.service.RoleService;
import com.example.PP_3_1_4_REST_JS.service.UserService;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    private UserService userService;
    private RoleService roleService;

    @Autowired
    public RestController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/")
    public ModelAndView mainPage(@AuthenticationPrincipal User loggedUser) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("loggeduser", loggedUser);
        return modelAndView;
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @PutMapping("/user")
    @ResponseBody
    public void userEdit(@RequestBody User user) {
        userService.saveUser(user);
    }

    @PostMapping("/user")
    public User userAdd(@RequestBody User newUser) {
        return userService.saveUser(newUser);
    }

    @DeleteMapping("/user/{id}")
    public void deleteAdd(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @GetMapping("users")
    public List<User> getUsers() {
        return userService.getUsersList();
    }

    @GetMapping("/roles")
    public List<Role> getRolesAll() {
        return roleService.getRoles();
    }
}
