package com.example.PP_3_1_4_REST_JS.service;

import com.example.PP_3_1_4_REST_JS.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    User saveUser(User user);
    User getUser(Long id);
    void deleteUser(Long id);
    List<User> getUsersList();

}
