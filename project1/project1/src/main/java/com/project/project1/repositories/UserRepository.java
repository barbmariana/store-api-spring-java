package com.project.project1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.project1.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
}
