package com.example.demo.controller;

import com.example.demo.dto.Account;
import com.example.demo.responses.DashboardAccount;
import com.example.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("add-account")
    public String addAccount(@RequestBody Account account){
        return accountService.addAccount(account);
    }

    @GetMapping("/get-account")
    public ResponseEntity<DashboardAccount> getAccount(@RequestParam Long accountId){
       return accountService.getAccount(accountId);
    }

    @GetMapping("/get-all-accounts")
    public List<DashboardAccount> getAllAccounts(@RequestParam("contactNumber") Long contactNumber){
        try {
            List<DashboardAccount> list = accountService.getAllAccounts(contactNumber);
              return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
