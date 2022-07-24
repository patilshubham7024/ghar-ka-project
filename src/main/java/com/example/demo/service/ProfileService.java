package com.example.demo.service;

import com.example.demo.dto.Profile;
import com.example.demo.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class ProfileService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private ProfileRepository profileRepository;

    public ResponseEntity<?> getProfile(String username) {
        Profile profile = profileRepository.findByUsername(username);
        return new ResponseEntity<>(profile, HttpStatus.OK);
    }
}
