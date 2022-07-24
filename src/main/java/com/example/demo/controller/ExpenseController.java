package com.example.demo.controller;

import com.example.demo.dto.Expense;
import com.example.demo.requests.AddExpense;
import com.example.demo.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/add-expense")
    public String addExpense(@RequestBody AddExpense expense){
        return expenseService.addExpense(expense);
    }
}
