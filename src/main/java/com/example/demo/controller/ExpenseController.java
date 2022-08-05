package com.example.demo.controller;

import com.example.demo.requests.AddExpense;
import com.example.demo.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/expense")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @GetMapping("/test")
    public String test(){
        return "Yes, this is my ghar ka project.";
    }

    @GetMapping("/see-expense")
    public ResponseEntity<?> seeExpense(@RequestParam Integer page,
                                        @RequestParam Integer size,
                                        @RequestParam Long contactNumber){
        return expenseService.seeExpense(page, size, contactNumber);
    }

    @PostMapping(value = "/add-expense"
//            , consumes = MediaType.APPLICATION_JSON_VALUE,
//            produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}
    )
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public String addExpense(@RequestBody AddExpense expense){
        return expenseService.addExpense(expense);
    }
}
