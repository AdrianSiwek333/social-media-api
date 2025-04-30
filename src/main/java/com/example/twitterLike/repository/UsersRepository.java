package com.example.twitterLike.repository;

import com.example.twitterLike.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {
}
