package com.varun.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.varun.Exceptions.UserNotFoundException;
import com.varun.entity.TestInfo;
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

	public String updateUserDetails(UserInfo info) {
		List<UserInfo> list = iuserrepository.findAll();
		for(UserInfo inf1: list)
		{
			if(inf1.getId().equals(info.getId()))
			{
				inf1.setName(info.getName());
				inf1.setEmail(info.getEmail());
				inf1.setMobileNumber(info.getMobileNumber());
				inf1.setPassword(info.getPassword());
				inf1.setCountry(info.getCountry());
				inf1.setState(info.getState());
				inf1.setCity(info.getCity());
				inf1.setZip(info.getZip());
			}
		}
		return "update succesfull";
	}

}
