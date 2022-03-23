package com.varun.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.varun.entity.TestInfo;
import com.varun.entity.UserInfo;

public interface ITestRepository extends JpaRepository<TestInfo,String>{

	TestInfo save(TestInfo info);

//	void delete(TestInfo info);

}
