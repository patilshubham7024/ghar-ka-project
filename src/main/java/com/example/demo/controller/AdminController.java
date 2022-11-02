package com.example.demo.controller;

import com.example.demo.dto.Profile;
import com.example.demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/all-users")
    public ResponseEntity<?> allUsers(@RequestParam Integer page,
                                      @RequestParam Integer size){
        return adminService.allUsers(page, size);
    }

    @PostMapping("/add-user")
    public String addUser(@RequestBody Profile profile){
        return adminService.addProfile(profile);
    }

}
