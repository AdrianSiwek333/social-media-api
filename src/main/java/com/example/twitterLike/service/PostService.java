package com.example.twitterLike.service;

import com.example.twitterLike.model.Post;
import com.example.twitterLike.repository.PostRepository;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public void addPost(Post post) {
        postRepository.save(post);
    }

    public void removePost(Post post) {
        postRepository.delete(post);
    }
}
