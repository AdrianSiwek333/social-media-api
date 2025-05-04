package com.example.twitterLike.repository;

import com.example.twitterLike.model.Post;
import com.example.twitterLike.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

    public void deleteAllByAuthor(Users author);
}
