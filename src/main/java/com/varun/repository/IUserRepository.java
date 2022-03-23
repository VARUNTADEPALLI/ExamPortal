package com.varun.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.varun.entity.UserInfo;


public interface IUserRepository extends JpaRepository<UserInfo,String>{

	public UserInfo save(UserInfo user);


	
	

}
