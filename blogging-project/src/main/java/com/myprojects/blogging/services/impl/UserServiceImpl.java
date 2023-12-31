package com.myprojects.blogging.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.myprojects.blogging.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import com.myprojects.blogging.repositories.UserRepo;
import com.myprojects.blogging.entities.User;
import com.myprojects.blogging.payloads.UserDto;
import com.myprojects.blogging.services.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDto createUser(UserDto userdto) {
		User user = this.DtotoUser(userdto);
		User savedUser = this.userRepo.save(user);

		return this.userToDto(savedUser);
	}

	@Override
	public UserDto updateUser(UserDto userdto, Integer userId) {

		User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","userId", userId));

		user.setName(userdto.getName());
		user.setEmail(userdto.getEmail());
		user.setPassword(userdto.getPassword());
		user.setAbout(userdto.getAbout());

		User updatedUser = this.userRepo.save(user);

		return this.userToDto(updatedUser);
	}

	@Override
	public UserDto getUserbyId(Integer userId) {
		User  user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "Id", userId));

		return this.userToDto(user);
	}

	@Override
	public List<UserDto> getallusers() {

		List<User> users = this.userRepo.findAll();

		List<UserDto> usersdtos = users.stream().map(user->this.userToDto(user)).collect(Collectors.toList());

		return usersdtos;
	}

	@Override
	public void deleteUser(Integer userId) {
		// TODO Auto-generated method stub

	}
	
	private User DtotoUser(UserDto userdto)
	{
		User user = new User();
		user.setId(userdto.getId());
		user.setName(userdto.getName());
		user.setEmail(userdto.getName());
		user.setPassword(userdto.getPassword());
		user.setAbout(userdto.getAbout());

		return user;
	}

	public UserDto userToDto(User user)
	{
		UserDto userdto = new UserDto();
		userdto.setId(user.getId());
		userdto.setName(user.getName());
		userdto.setEmail(user.getEmail());
		userdto.setPassword(user.getPassword());
		userdto.setAbout(user.getAbout());

		return userdto;
	}

}
