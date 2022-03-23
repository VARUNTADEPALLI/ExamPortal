package com.varun.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
			 test=testservice.validateUser(id);
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
	
	
	
//	@PutMapping(value="updateTestDetails/{id}")
//	public Optional<TestInfo> updateTestDetails(@PathVariable(value = "id") String id,@RequestBody TestInfo info)
//	{
//		Optional<TestInfo> test_info = itestrepository.findById(id);
//		info.setId(id);
//		test_info.setOption1(info.getOption1());
//		test_info.setOption2(option2);
//		test_info.setOption3(option3);
//		test_info.setOption4(option4);
//		testservice.removeTestDetails(info);
//		return info;
//		
//	}
}