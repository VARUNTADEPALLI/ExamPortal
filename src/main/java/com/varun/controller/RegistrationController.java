package com.varun.controller;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.varun.Exceptions.UserNotFoundException;
import com.varun.entity.UserInfo;
import com.varun.service.IUserService;
import com.varun.service.IUserServiceImpl;



@CrossOrigin("*")
@RestController
public class RegistrationController {

	@Autowired
	private IUserServiceImpl loginservice;
	
	@PostMapping(value="saveUserDetails")
	public UserInfo saveUserDetails(@RequestBody UserInfo user)
	{
		
		loginservice.addUser(user);
		return user;
		
	}
	
	@DeleteMapping(value="deleteUserDetails/{id}")
	public void deleteUserDetails(@PathVariable("id") String id)
	{
		loginservice.removeUser(id);
	}
	
	
	@GetMapping("/getUser/{id}")
	public Optional<UserInfo> getUser(@PathVariable("id") String id)
	{
		Optional<UserInfo> user=loginservice.validateUser(id);
		
		return user;
	}
	
	
	
	@GetMapping("/getUsers")
	public List<UserInfo> getUsers()
	{
		List<UserInfo> user=loginservice.getAllUsers();
		
		return user;
	}
	
	
	
	}
	
	