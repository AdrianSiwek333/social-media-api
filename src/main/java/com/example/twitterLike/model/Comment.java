package com.example.twitterLike.model;

import jakarta.persistence.*;

@Entity
public class Comment extends Post {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", insertable = false, updatable = false)
    private Post parentPost;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    public Comment() {
    }

    public Comment(String content, Post parentPost, Users user) {
        super(content, user);
        this.parentPost = parentPost;
        this.user = user;
    }

    public Post getParentPost() {
        return parentPost;
    }

    public void setParentPost(Post parentPost) {
        this.parentPost = parentPost;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}