package com.example.demo.service;

import com.example.demo.dto.Profile;
import com.example.demo.repository.ProfileRepository;
import com.example.demo.responses.FilterResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private ProfileRepository profileRepository;

    public ResponseEntity<?> allUsers(Integer page, Integer size) {
        try{
            FilterResponse response = new FilterResponse(
                    profileRepository.findAll(PageRequest.of(page,size)).toList(),
                    "All users.");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception exception){
            return new ResponseEntity<>("Something went wrong.",HttpStatus.BAD_REQUEST);
        }
    }

    public String addProfile(Profile profile) {
        try{
            profileRepository.save(profile);
            return "Added";
        }catch (Exception exception){
            return "Something went wrong.";
        }
    }
}
