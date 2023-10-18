package com.backend.main.service.impl;

import org.springframework.stereotype.Service;

import com.backend.main.model.Post;
import com.backend.main.repository.PostRepo;
import com.backend.main.service.PostService;
import com.backend.main.service.UserService;

@Service
public class PostServiceImpl implements PostService{

	private PostRepo postRepo;
	private UserService userService;
	
	public PostServiceImpl(PostRepo postRepo,UserService userService) {
		super();
		this.postRepo = postRepo;
		this.userService = userService;
	}

	@Override
	public Post createPost(int userId, Post post) {
		post.setUser(userService.getUser(userId));
		postRepo.save(post);
		return post;
	}
	

}
