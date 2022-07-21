package com.example.demo.controller;

import com.example.demo.dto.Credit;
import com.example.demo.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/credit")
public class CreditController {

    @Autowired
    private CreditService creditService;

    @GetMapping("/test")
    public String test(){
        return "Yes, this is my ghar ka project.";
    }

    @GetMapping("/see-credit")
    public ResponseEntity<?> seeCredit(@RequestParam Integer page,
                                        @RequestParam Integer size){
        return creditService.seeCredit(page, size);
    }

    @PostMapping("/add-credit")
    public String addCredit(@RequestBody Credit credit){
        return creditService.addCredit(credit);
    }
}
