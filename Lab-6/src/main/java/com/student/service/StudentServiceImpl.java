package com.student.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.exception.ResourceNotFoundException;
import com.student.model.Student;
import com.student.payload.StudentDto;
import com.student.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private ModelMapper mapper;

	@Override
	public StudentDto create(StudentDto studentDto) {
		// TODO Auto-generated method stub
		Student student = this.mapper.map(studentDto, Student.class);
		Student createdStudent = this.studentRepository.save(student);
		return this.mapper.map(createdStudent, StudentDto.class);
	}

	@Override
	public StudentDto update(StudentDto studentDto, int id) {
		// TODO Auto-generated method stub
		Student student = this.studentRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Student not found"));
		student.setName(studentDto.getName());
		student.setDept(studentDto.getDept());
		student.setCountry(studentDto.getCountry());
		Student updatedStudent = this.studentRepository.save(student);
		return this.mapper.map(updatedStudent, StudentDto.class);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		Student student = this.studentRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Student not found"));
		this.studentRepository.delete(student);
	}

	@Override
	public List<StudentDto> getAll() {
		// TODO Auto-generated method stub
		List<Student> allStudents = this.studentRepository.findAll();
		List<StudentDto> allDtos = allStudents.stream().map(student -> this.mapper.map(student, StudentDto.class)).collect(Collectors.toList());
		return allDtos;
	}

	@Override
	public StudentDto getById(int id) {
		// TODO Auto-generated method stub
		Student student = this.studentRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Student not found"));
		return this.mapper.map(student, StudentDto.class);
	}

}
