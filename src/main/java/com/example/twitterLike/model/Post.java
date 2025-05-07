package com.example.twitterLike.model;

import com.example.twitterLike.dto.CommentDto;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    @Column(length = 255, nullable = false)
    private String content;

    @OneToMany(mappedBy = "parentPost", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH},
            fetch = FetchType.LAZY)
    private List<Comment> childComments = new ArrayList<>();

    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private Users author;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    public Post() {
    }

    public Post(String content, Users author) {
        this.content = content;
        this.author = author;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Users getAuthor() {
        return author;
    }

    public void setAuthor(Users author) {
        this.author = author;
    }

    public List<Comment> getChildComments() {
        return childComments;
    }

    public void setChildComments(List<Comment> childComments) {
        this.childComments = childComments;
    }

    public List<CommentDto> getChildCommentsDto() {
        List<CommentDto> commentDto = new ArrayList<>();
        for (Comment comment : childComments) {
            commentDto.add(new CommentDto(comment.getPostId(), comment.getContent(),
                    comment.getAuthor().getUsername(), comment.getCreatedAt()));
        }
        return commentDto;
    }

}