package com.backend.main.service;

import com.backend.main.model.Post;

public interface PostService {

	Post createPost(int userId, Post post);
}
