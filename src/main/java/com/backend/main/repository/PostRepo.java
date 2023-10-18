package com.backend.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.main.model.Post;

public interface PostRepo extends JpaRepository<Post, Integer>{

}
