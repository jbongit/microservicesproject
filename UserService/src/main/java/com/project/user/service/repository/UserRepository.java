package com.project.user.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.user.service.entities.User;

public interface UserRepository extends JpaRepository<User, String>{
}
