package com.example.twitterLike.repository;

import com.example.twitterLike.model.Interaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InteractionRepository extends JpaRepository<Interaction, Long> {
    // Custom query methods can be defined here if needed
    // For example, to find interactions by userId or postId
    // List<Interaction> findByUserId(Long userId);
    // List<Interaction> findByPostId(Long postId);
}
