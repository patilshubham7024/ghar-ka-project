package com.example.demo.repository;

import com.example.demo.dto.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {


    Profile findByUsername(String username);
}
