package com.backend.main.service.impl;

import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.backend.main.exception.ResourceNotFoundException;
import com.backend.main.model.Post;
import com.backend.main.model.User;
import com.backend.main.repository.UserRepo;
import com.backend.main.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	private UserRepo userRepo; 
	
	public UserServiceImpl(UserRepo userRepo) {
		super();
		this.userRepo = userRepo;
	}	

	@Override
	public List<User> getUsers() {
		return userRepo.findAll();
	}

	@Override
	public User addUser(User user) {
		return userRepo.save(user);
	}



	@Override
	public User updateUser(User user) {
		User existedUser = userRepo.findById(user.getUserId()).orElseThrow(() -> 
							new ResourceNotFoundException("User", "ID", user.getUserId()));
		
		existedUser.setUserName(user.getUserName());
		existedUser.setPassword(user.getPassword());
		existedUser.setEmailId(user.getEmailId());
		userRepo.save(existedUser);
		
		return existedUser;
	}



	@Override
	public String deleteUser(int id) {
		
		if(userRepo.existsById(id)) {
			userRepo.deleteById(id);
			return "User deleted of ID : " + id;
		}else {
			throw new ResourceNotFoundException("User","Id",id);
		}
	}

	@Override
	public User getUser(int id) {
		return userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User","Id",id));
	}
	
	@Override
	public List<User> getAllUsersSortedByName() {
        List<User> users = userRepo.findAll();
        users.sort(Comparator.comparing(User::getUserName));
        return users;
	}
	
	@Override
	public List<User> getAllUsersSortedByDate() {
		List<User> users = userRepo.findAll();
		users.sort(Comparator.comparing(User::getCreateDate).reversed());
		return users;
	}

	@Override
	public List<Post> getPostsOfUser(int id) {
		
		User user = userRepo.findById(id).orElseThrow(() 
					-> new ResourceNotFoundException("User","Id",id));	
		return user.getPosts();
	}


}
