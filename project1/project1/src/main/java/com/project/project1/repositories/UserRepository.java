package com.project.project1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.project1.entities.User;

//Dont need to put annotation, but can use. JPA tels me I am a repository
public interface UserRepository extends JpaRepository<User, Long> {
	
}
// Don't need to put anything in this inteface because JPA repository creates
// for us the repository for the entity and the type.
