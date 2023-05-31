package com.jayk0918.www.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jayk0918.www.entity.Users;

public interface UserRepository extends JpaRepository<Users, Long>{
	
	Optional<Users> findById(Long userId);
	
}
