package com.example.PP_3_1_4_REST_JS.service;

import com.example.PP_3_1_4_REST_JS.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAllRoles();

    void updateRole(Role role);

    void removeRoleById(long id);

    void addRole(Role role);

    Role getRoleByName(String name);
}
