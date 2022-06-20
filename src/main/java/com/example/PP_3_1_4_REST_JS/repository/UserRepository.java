package com.example.PP_3_1_4_REST_JS.repository;

import com.example.PP_3_1_4_REST_JS.model.User;
import org.springframework.data.jpa.repository.JpaRepository;




public interface UserRepository extends JpaRepository<User, Long> {

    User findByName(String name);

    User getUserById(long id);

}
