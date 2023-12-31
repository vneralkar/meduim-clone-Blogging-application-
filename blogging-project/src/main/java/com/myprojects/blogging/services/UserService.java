package com.myprojects.blogging.services;

import java.util.List;

import com.myprojects.blogging.payloads.UserDto;

public interface UserService {
	
	UserDto createUser(UserDto user);
	UserDto updateUser(UserDto user, Integer userId);
	UserDto getUserbyId(Integer userId );
	List<UserDto> getallusers();
	void deleteUser(Integer userId );
	

}
