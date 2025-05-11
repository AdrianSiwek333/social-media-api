package com.example.twitterLike.repository;

import com.example.twitterLike.model.ERole;
import com.example.twitterLike.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
