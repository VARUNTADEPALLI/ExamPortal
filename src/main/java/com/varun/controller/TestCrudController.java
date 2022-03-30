package com.varun.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.varun.Exceptions.UserNotFoundException;
import com.varun.entity.TestInfo;
import com.varun.entity.UserInfo;
import com.varun.repository.ITestRepository;
import com.varun.service.ITestServiceImpl;

@CrossOrigin("*")
@RestController
public class TestCrudController {

	@Autowired
	private ITestServiceImpl testservice;
	
	@Autowired
	private ITestRepository itestrepository;
	
	@PostMapping(value="saveTestDetails")
	public TestInfo saveTestDetails(@RequestBody TestInfo info)
	{
		
		testservice.addTestDetails(info);
		return info;
	}
	
	@DeleteMapping(value="deleteTestDetails/{id}")
	public void deleteTestDetails(@PathVariable("id") String id)
	{
		
		testservice.removeTestDetails(id);
	}
	
	
	@GetMapping("/getTest/{id}")
	public Optional<TestInfo> getUser(@PathVariable("id") String id) throws UserNotFoundException{
		Optional<TestInfo> test= null;
		try
		{
			 test=testservice.getTestQuestionById(id);
			 if(test==null)
			 {
				 throw new UserNotFoundException("User not found");
			 }
		}
		catch(UserNotFoundException e)
		{
			System.out.print(e.getMessage());
		}
		return test;
	}
	
	
	@GetMapping("/getAllTestQuestions")
	public List<TestInfo> getUsers()
	{
		List<TestInfo> user=testservice.getAllTestQuestions();
		
		return user;
	}
	
	@PutMapping("/updateTestDetails")
	public String updateDetails(@RequestBody TestInfo info)
	{
		String inf = testservice.updateTestQuestion(info);
		
        return inf;
		
		
	}
	
	
	
	
	

}