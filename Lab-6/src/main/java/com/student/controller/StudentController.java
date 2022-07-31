package com.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.payload.APIResponse;
import com.student.payload.StudentDto;
import com.student.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/")
	public ResponseEntity<StudentDto> create(@RequestBody StudentDto studentDto){
		StudentDto createdStudent = this.studentService.create(studentDto);
		return new ResponseEntity<StudentDto>(createdStudent,HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<StudentDto> update(@RequestBody StudentDto studentDto, @PathVariable int id){
		StudentDto updatedStudent = this.studentService.update(studentDto, id);
		return new ResponseEntity<StudentDto>(updatedStudent,HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/{id}")
	public ResponseEntity<APIResponse> delete(@PathVariable int id){
		this.studentService.delete(id);
		return new ResponseEntity<APIResponse>(new APIResponse("Student deleted successfully", true),HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<StudentDto>> getAll(){
		List<StudentDto> all = this.studentService.getAll();
		return new ResponseEntity<List<StudentDto>>(all,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<StudentDto> getById(@PathVariable int id){
		StudentDto studentDto = this.studentService.getById(id);
		return new ResponseEntity<StudentDto>(studentDto,HttpStatus.OK);
	}
}
