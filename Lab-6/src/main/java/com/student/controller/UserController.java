package com.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.model.UserDto;
import com.student.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@PostMapping("/")
	public ResponseEntity<UserDto> create(@RequestBody UserDto userDto){
		userDto.setPassword(this.passwordEncoder.encode(userDto.getPassword()));
		UserDto createdUser = this.userService.create(userDto);
		return new ResponseEntity<UserDto>(createdUser,HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAll(){
		List<UserDto> all = this.userService.getAll();
		return new ResponseEntity<List<UserDto>>(all,HttpStatus.OK);
	}
}
