package com.student.service;

import java.util.List;

import com.student.model.UserDto;

public interface UserService {

	public UserDto create(UserDto userDto);
	
	public List<UserDto> getAll();
}
