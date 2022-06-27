package com.example.PP_3_1_4_REST_JS.service;

import com.example.PP_3_1_4_REST_JS.model.Role;

import java.util.List;

public interface RoleService {

    List<Role> getRoles();

    Role getRole(Long id);

    void saveRole(Role role);

    void deleteRole(Role role);
}
