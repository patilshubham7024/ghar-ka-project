package com.example.demo.controller;

import com.example.demo.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/profile")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @GetMapping("/get-profile")
    private ResponseEntity<?> getProfile(@RequestParam String username){
        return profileService.getProfile(username);
    }
}
