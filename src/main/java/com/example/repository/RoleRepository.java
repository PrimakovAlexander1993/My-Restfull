package com.example.repository;

import com.example.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository

public interface RoleRepository extends JpaRepository<Role, Long> {
    @Transactional
    Long countRoleByRole(String name);
    @Transactional
    Role getRole(String name);
}
