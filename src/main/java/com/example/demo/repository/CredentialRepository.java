package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.Credential;

@Repository
public interface CredentialRepository extends JpaRepository<Credential, Integer>{

	@Query("select c from Credential c where c.username= : username")
	Credential getCredentialsByUsername(@Param("username")String username);
	
}
