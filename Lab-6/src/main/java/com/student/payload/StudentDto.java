package com.student.payload;

public class StudentDto {

	private int id;
	private String name;
	private String dept;
	private String country;
	
	
	public StudentDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public StudentDto(int id, String name, String dept, String country) {
		super();
		this.id = id;
		this.name = name;
		this.dept = dept;
		this.country = country;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDept() {
		return dept;
	}


	public void setDept(String dept) {
		this.dept = dept;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}
	
	
	
	
}
