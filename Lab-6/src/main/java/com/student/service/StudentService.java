package com.student.service;

import java.util.List;

import com.student.payload.StudentDto;

public interface StudentService {

	public StudentDto create(StudentDto studentDto);
	
	public StudentDto update(StudentDto studentDto, int id);
	
	public void delete(int id);
	
	public List<StudentDto> getAll();
	
	public StudentDto getById(int id);
}
