package com.example.twitterLike.service;

import com.example.twitterLike.dto.CommentDto;
import com.example.twitterLike.exception.PostNotFoundException;
import com.example.twitterLike.mapper.CommentMapper;
import com.example.twitterLike.model.Comment;
import com.example.twitterLike.repository.CommentRepository;
import com.example.twitterLike.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;
    private final PostRepository postRepository;

    public CommentService(CommentRepository commentRepository, CommentMapper commentMapper,
                          PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.commentMapper = commentMapper;
        this.postRepository = postRepository;
    }

    public void addComment(Comment comment) {
        commentRepository.save(comment);
    }

    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }

    public CommentDto getCommentById(Long commentId) {
        return commentMapper.mapToCommentDto(
                commentRepository.findById(commentId).orElseThrow(
                        () -> new PostNotFoundException("Comment not found")
                )
        );
    }

    public List<CommentDto> getCommentsByPostId(Long postId) {
        return commentMapper.mapToCommentDtoList(
                commentRepository.findByParentPost(postRepository.findById(
                        postId).orElseThrow(
                                () -> new PostNotFoundException("Post not found")
                ))
        );
    }
}
