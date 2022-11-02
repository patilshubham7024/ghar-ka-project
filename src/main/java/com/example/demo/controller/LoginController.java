package com.example.demo.controller;

import com.example.demo.dto.Credential;
import com.example.demo.responses.LoginResponse;
import com.example.demo.service.LoginService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Log4j2
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public LoginResponse validateLogin(@RequestBody Credential credential){
        log.info("LoginController->validateLogin()");
        return loginService.validateLogin(credential);
    }
}
