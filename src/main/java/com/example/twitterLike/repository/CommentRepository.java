package com.example.twitterLike.repository;

import com.example.twitterLike.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    // Custom query methods can be defined here if needed
}
