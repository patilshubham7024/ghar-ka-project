package com.example.demo.controller;

import com.example.demo.dto.Credit;
import com.example.demo.requests.AddCredit;
import com.example.demo.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/credit")
public class CreditController {

    @Autowired
    private CreditService creditService;

    @RequestMapping("/test")
    public String test(){
        return "home";
    }

    @GetMapping("/see-credit")
    public ResponseEntity<?> seeCredit(@RequestParam Integer page,
                                        @RequestParam Integer size,
                                       @RequestParam Long contactNumber){
        return creditService.seeCredit(page, size, contactNumber);
    }

    @PostMapping("/add-credit")
    public String addCredit(@RequestBody AddCredit credit){
        return creditService.addCredit(credit);
    }
}
