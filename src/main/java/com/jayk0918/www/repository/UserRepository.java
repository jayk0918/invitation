package com.jayk0918.www.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jayk0918.www.entity.Users;

public interface UserRepository extends JpaRepository<Users, Long>{
}
