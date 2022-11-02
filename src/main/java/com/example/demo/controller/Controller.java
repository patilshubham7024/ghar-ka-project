package com.example.demo.controller;

import com.example.demo.service.GharKiService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class Controller {

    @Autowired
    private GharKiService gharKiService;

    @GetMapping("/test")
    public String test(){
        log.info("Testing-----------");
        return gharKiService.test();
    }

//    @GetMapping("/dashboard")
//    public ResponseEntity<?> dashboard(){
//        return gharKiService.dashboard();
//    }

}
