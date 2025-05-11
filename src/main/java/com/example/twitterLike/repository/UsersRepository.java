package com.example.twitterLike.repository;

import com.example.twitterLike.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

    public Optional<Users> findByUsername(String username);

    public Optional<Users> findByEmail(String email);

    public Boolean existsByUsername(String username);

    public Boolean existsByEmail(String email);
}
