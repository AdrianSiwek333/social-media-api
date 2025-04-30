package com.example.twitterLike.repository;

import com.example.twitterLike.model.Follow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FollowRepository extends JpaRepository<Follow, Long> {
    // Custom query methods can be defined here if needed
    // For example, to find all followers of a user:
    // List<Follow> findByFollowerId(Long followerId);
}
