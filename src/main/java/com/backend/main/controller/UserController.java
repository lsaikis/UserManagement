package com.backend.main.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.main.model.Post;
import com.backend.main.model.User;
import com.backend.main.service.PostService;
import com.backend.main.service.UserService;

import jakarta.validation.Valid;

@RestController
public class UserController {

	private UserService userService;
	private PostService postService;

	public UserController(UserService userService, PostService postService) {
		super();
		this.userService = userService;
		this.postService = postService;
	}

	@PostMapping("/users")
	public User addUser(@Valid @RequestBody User user) {
		return userService.addUser(user);
	}

	/*
	 * @GetMapping("users{id}") public ResponseEntity<User> getUser(@PathVariable
	 * int id) { return new
	 * ResponseEntity<User>(userService.getUser(id),HttpStatus.OK); }
	 */

	
	
	  @GetMapping("/users/{id}")
	  public EntityModel<User> getUser(@PathVariable int id) {
	  
	  EntityModel<User> eUser = EntityModel.of(userService.getUser(id)); // getting the user by id and making into EntityModel 
	  WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).getUsers());//Generating link of rated method by using static methods in WebMvcLinkBuilder class
	  eUser.add(link.withRel("all_users")); //add the link to the entity model with related to its name
	  
	  return eUser; 
	  
	  }
	 
	 

	@GetMapping("/users")
	public ResponseEntity<List<User>> getUsers() {
		return new ResponseEntity<List<User>>(userService.getUsers(), HttpStatus.OK);
	}

	@PutMapping("/users")
	public User updateUser(@RequestBody User user) {
		return userService.updateUser(user);
	}

	@DeleteMapping("/users/{id}")
	public String deleteUser(@PathVariable int id) {
		return userService.deleteUser(id);
	}

	@GetMapping("/users/")
	public List<User> getUsers(@RequestParam("sort") String type) {

		switch (type) {
		case "name":
			return userService.getAllUsersSortedByName();

		case "date":
			return userService.getAllUsersSortedByDate();

		default:
			return userService.getUsers();
		}
	}
	

	@GetMapping("/users/{id}/posts")
	public List<Post> retrieveAllPosts(@PathVariable int id) {
		return userService.getPostsOfUser(id);
	}
	
	@PostMapping("/users/{id}/posts")
	public EntityModel<Post> addPostTouser(@PathVariable int id, @RequestBody Post post) {
		
		EntityModel<Post> ePost = EntityModel.of(postService.createPost(id, post));
		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllPosts(id));
		ePost.add(link.withRel("all_users"));
		
		return ePost;
				
	}
	


}
