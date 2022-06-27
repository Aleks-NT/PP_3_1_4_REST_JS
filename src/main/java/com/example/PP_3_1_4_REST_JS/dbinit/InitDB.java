package com.example.PP_3_1_4_REST_JS.dbinit;


import com.example.PP_3_1_4_REST_JS.model.Role;
import com.example.PP_3_1_4_REST_JS.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.PP_3_1_4_REST_JS.service.RoleService;
import com.example.PP_3_1_4_REST_JS.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Component
public class InitDB {
    private UserService userService;
    private RoleService roleService;

    @Autowired
    public InitDB(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @javax.annotation.PostConstruct
    public void init() {

        Role roleAdmin = new Role("ROLE_ADMIN");
        roleService.saveRole(roleAdmin);
        Role roleUser = new Role("ROLE_USER");
        roleService.saveRole(roleUser);

        List<Role> roleSet1 = new ArrayList<>();
        roleSet1.add(roleAdmin);
        roleSet1.add(roleUser);
        List<Role> roleSet2 = new ArrayList<>();
        roleSet2.add(roleUser);


        userService.saveUser(new User("Александр", "Сорокатый", 43, "sorokatiy@mail.ru", "admin", roleSet1));
        userService.saveUser(new User("Леонид", "Ковалев", 19, "kovalev@mail.ru", "user", roleSet2));

    }


}
