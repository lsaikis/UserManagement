package com.backend.main.service;

import java.util.List;

import com.backend.main.model.Post;
import com.backend.main.model.User;

public interface UserService {

	public User addUser(User user);
	
	public User getUser(int id);
	
	public List<User> getUsers();
	
	public User updateUser(User user);
	
	public String deleteUser(int id);
	
	public List<User> getAllUsersSortedByName();
	
	public List<User> getAllUsersSortedByDate() ;
	
	public List<Post> getPostsOfUser(int id);

}
