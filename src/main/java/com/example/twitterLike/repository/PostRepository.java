package com.example.twitterLike.repository;

import com.example.twitterLike.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
    // Custom query methods can be defined here if needed
}
