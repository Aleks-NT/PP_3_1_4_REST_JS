package com.example.PP_3_1_4_REST_JS.service;

import com.example.PP_3_1_4_REST_JS.model.User;
import com.example.PP_3_1_4_REST_JS.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


    @Override
    public void addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public void deleteUserById(long id) {
        userRepository.deleteById(id);
    }


    @Override
    public User getUserById(long id) {
        return userRepository.getUserById(id);
    }

    @Override
    public void updateUser(User user) {
        String passwordFromForm = user.getPassword();
        String encodedPasswordFromBase = userRepository.getUserById(user.getId()).getPassword();
        if (passwordFromForm.length() == 0 || passwordFromForm.equals(encodedPasswordFromBase)) {
            user.setPassword(encodedPasswordFromBase);
        } else {
            if (passwordEncoder.matches(passwordFromForm, encodedPasswordFromBase)) {
                user.setPassword(encodedPasswordFromBase);
            } else {
                user.setPassword(passwordEncoder.encode(passwordFromForm));
            }
        }
        userRepository.save(user);
    }
}