package com.varun.service;

import java.util.List;

import com.varun.entity.UserInfo;

public interface IUserService {

	public  UserInfo addUser(UserInfo user);
	public  UserInfo removeUser(UserInfo user);
	public UserInfo validateUser(String id);
	public List<UserInfo> getAllUsers();
}
