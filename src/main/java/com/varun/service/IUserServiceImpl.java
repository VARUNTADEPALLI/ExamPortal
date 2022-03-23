package com.varun.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.varun.Exceptions.UserNotFoundException;
import com.varun.entity.UserInfo;
import com.varun.repository.IUserRepository;
@Service
@Transactional
public class IUserServiceImpl {
	  @Autowired
	  private IUserRepository iuserrepository;

	public UserInfo addUser(UserInfo user) {
		return iuserrepository.save(user);
		
	}

	public void removeUser(String id) {
		
		 iuserrepository.deleteById(id);
	}

	public Optional<UserInfo> validateUser(String id) {
		
		Optional<UserInfo> user_info=iuserrepository.findById(id);
		
			  return user_info;
		  
	}

	public List<UserInfo> getAllUsers() {
		List<UserInfo> list =iuserrepository.findAll();
		return list;
	}

}
