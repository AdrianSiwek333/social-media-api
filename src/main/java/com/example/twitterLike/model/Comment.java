package com.example.twitterLike.model;

import jakarta.persistence.*;

@Entity
public class Comment extends Post {

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "parent_id")
    private Post parentPost;

    public Comment() {
    }

    public Comment(String content, Post parentPost, Users author) {
        super(content, author);
        this.parentPost = parentPost;
    }

    public Comment(String content, Users author) {
        super(content, author);
    }

    public Post getParentPost() {
        return parentPost;
    }

    public void setParentPost(Post parentPost) {
        this.parentPost = parentPost;
    }

}