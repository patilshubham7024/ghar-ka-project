package com.example.demo.service;

import com.example.demo.dto.Credential;
import com.example.demo.repository.CredentialRepository;
import com.example.demo.responses.LoginResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Log4j2
public class LoginService {
    @Autowired
    private CredentialRepository credentialRepository;

    public LoginResponse validateLogin(Credential credential){
        log.info("LoginService->validateLogin()");
        LoginResponse response= LoginResponse.builder().build();
        try{
            Optional<Credential> optional=credentialRepository.findByUsername(credential.getUsername());
            if(optional.isPresent()){
                Credential credential1=optional.get();
                if(credential1.getUsername().equalsIgnoreCase(credential.getUsername())){
                    if(!credential1.getPassword().equalsIgnoreCase(credential.getPassword())){
                        throw new RuntimeException("Invalid password");
                    } else{
                    response=LoginResponse.builder().status("Success").message("Login success").username(credential.getUsername()).build();
                    }
                }
            }  else {
                throw new RuntimeException("Invalid username");
            }
        }catch (Exception e){
            response.setStatus("Failed");
            response.setMessage(e.getMessage());
        }
        return response;
    }
}
