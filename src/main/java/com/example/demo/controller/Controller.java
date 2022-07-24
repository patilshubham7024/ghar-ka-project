package com.example.demo.controller;

import com.example.demo.service.GharKiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    private GharKiService gharKiService;

    @GetMapping("/dashboard")
    public ResponseEntity<?> dashboard(){
        return gharKiService.dashboard();
    }

}
