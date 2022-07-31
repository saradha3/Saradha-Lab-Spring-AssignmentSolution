package com.student.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.model.User;
import com.student.model.UserDto;
import com.student.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public UserDto create(UserDto userDto) {
		// TODO Auto-generated method stub
		User user = this.mapper.map(userDto, User.class);
		user.setRole("ROLE_"+user.getRole());
		User createdUser = this.userRepository.save(user);
		return this.mapper.map(createdUser, UserDto.class);
	}

	@Override
	public List<UserDto> getAll() {
		// TODO Auto-generated method stub
		List<User> all = this.userRepository.findAll();
		List<UserDto> allDtos = all.stream().map(user -> this.mapper.map(user, UserDto.class)).collect(Collectors.toList());
		return allDtos;
	}

}
