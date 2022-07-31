package com.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	public User findByUsername(String username);
}
