package com.example.PP_3_1_4_REST_JS.repository;

import com.example.PP_3_1_4_REST_JS.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String role);
}
