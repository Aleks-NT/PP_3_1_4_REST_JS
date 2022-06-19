package com.example.PP_3_1_4_REST_JS.dbInit;


import com.example.PP_3_1_4_REST_JS.model.Role;
import com.example.PP_3_1_4_REST_JS.model.User;
import com.example.PP_3_1_4_REST_JS.service.RoleService;
import com.example.PP_3_1_4_REST_JS.service.UserService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class InitDB {
    private final UserService userService;
    private final RoleService roleService;

    public InitDB(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    private void addUsersInDB() {
        User admin = new User("admin", "Sorokatiy", 43, "Sor@mail.ru", "admin");
        User user = new User("user", "Kovalev", 19, "Kov@mail.ru", "user");
        Role adminRole = new Role("ROLE_ADMIN");
        Role userRole = new Role("ROLE_USER");
        roleService.addRole(adminRole);
        roleService.addRole(userRole);
        admin.setOneRole(adminRole);
        user.setOneRole(userRole);
        userService.addUser(admin);
        userService.addUser(user);
    }
}
