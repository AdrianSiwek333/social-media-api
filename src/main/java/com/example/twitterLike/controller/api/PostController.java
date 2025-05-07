package com.example.twitterLike.controller.api;

import com.example.twitterLike.dto.CommentDto;
import com.example.twitterLike.dto.PostDto;
import com.example.twitterLike.model.Post;
import com.example.twitterLike.model.Users;
import com.example.twitterLike.service.CommentService;
import com.example.twitterLike.service.PostService;
import com.example.twitterLike.service.UsersService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;
    private final CommentService commentService;
    private final UsersService usersService;

    public PostController(PostService postService, CommentService commentService, UsersService usersService) {
        this.postService = postService;
        this.commentService = commentService;
        this.usersService = usersService;
    }

    @GetMapping("/all")
    public List<PostDto> getAllPosts(){
        return postService.findAllPosts();
    }

    @GetMapping("/{postId}")
    public PostDto getPostById(@PathVariable Long postId){
        return postService.findPostById(postId);
    }

    @PostMapping("/add")
    public void addPost(@RequestBody Post post){
        postService.addPost(post);
    }

}
