package com.simplilearn.workshop.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.workshop.domain.User;
import com.simplilearn.workshop.service.user.UserServiceIF;

@RestController
public class UserResource {

	@Autowired
	private UserServiceIF userServiceIF;

	@PostMapping("/user/authenticate")
	public User authenticateUser(@RequestParam("userId") String strUserId, @RequestParam("pwd") String strPwd) {
		return userServiceIF.authenticate(strUserId, strPwd);
	}

	@GetMapping("/user/find/byId/{strId}")
	public User getUserById(@PathVariable("strId") String strId) {
		return userServiceIF.getUserById(strId);
	}

	@GetMapping("/user/find/byEmail/{strEmail}")
	public User getUserByEmail(@PathVariable("strEmail") String strEmail) {
		System.out.println(strEmail);
		return userServiceIF.getUserByEmail(strEmail);
	}

	@PostMapping("/user/save")
	public User saveUser(@Valid @RequestBody User user) {
		return userServiceIF.saveUser(user);
	}

	@GetMapping("/user/all")
	public List<User> getAllUsers() {
		return userServiceIF.getAllUsers();
	}
}
