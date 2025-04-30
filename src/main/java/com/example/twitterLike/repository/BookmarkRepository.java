package com.example.twitterLike.repository;

import com.example.twitterLike.model.Bookmark;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {


}
