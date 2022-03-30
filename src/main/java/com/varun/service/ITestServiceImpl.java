package com.varun.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

	public Optional<TestInfo> getTestQuestionById(String id) {
		Optional<TestInfo> user_info=itestrepository.findById(id);
		  return user_info;
	}

	public List<TestInfo> getAllTestQuestions() {
		List<TestInfo> list =itestrepository.findAll();
		return list;
	}



	public String  updateTestQuestion(TestInfo info) {
		List<TestInfo> list = itestrepository.findAll();
		for(TestInfo inf1: list)
		{
			if(inf1.getId().equals(info.getId()))
			{
				inf1.setQuestion(info.getQuestion());
				inf1.setOption1(info.getOption1());
				inf1.setOption2(info.getOption2());
				inf1.setOption3(info.getOption3());
				inf1.setOption4(info.getOption4());
			}
		}
		return "update succesfull";
	}

}
