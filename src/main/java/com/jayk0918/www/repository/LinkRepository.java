package com.jayk0918.www.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jayk0918.www.entity.Links;

public interface LinkRepository extends JpaRepository<Links, Long>{
	
	Long getUserIdByUrl(String url);
	
}
