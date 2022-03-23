package com.varun.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.varun.entity.TestInfo;
import com.varun.entity.UserInfo;
import com.varun.repository.ITestRepository;

@Service
@Transactional
public class ITestServiceImpl {
	@Autowired
	private ITestRepository itestrepository;

	public TestInfo addTestDetails(TestInfo info)
	{
		
	return itestrepository.save(info);
		
	}

	public void removeTestDetails(String id) {
		itestrepository.deleteById(id);
		
		
	}

	public Optional<TestInfo> validateUser(String id) {
		Optional<TestInfo> user_info=itestrepository.findById(id);
		  return user_info;
	}

}
