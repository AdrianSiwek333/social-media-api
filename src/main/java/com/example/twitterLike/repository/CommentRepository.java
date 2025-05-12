package com.example.twitterLike.repository;

import com.example.twitterLike.model.Comment;
import com.example.twitterLike.model.Post;
import com.example.twitterLike.model.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    void deleteAllByAuthor(Users author);

    public Page<Comment> findByParentPost(Post parentPost, Pageable pageable);
}
