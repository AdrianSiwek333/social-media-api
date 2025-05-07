package com.example.twitterLike.mapper;

import com.example.twitterLike.dto.PostDto;
import com.example.twitterLike.model.Post;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PostMapper {

    public PostDto mapToPostDto(Post post) {
        return new PostDto(
                post.getPostId(),
                post.getContent(),
                post.getAuthor().getUsername(),
                post.getCreatedAt()
        );
    }

    public List<PostDto> mapToPostDtoList(List<Post> posts) {
        return posts.stream()
                .map(this::mapToPostDto)
                .toList();
    }
}
