package com.example.demo.service;

import com.example.demo.dto.Expense;
import com.example.demo.enums.RecordStatus;
import com.example.demo.repository.ExpenseRepository;
import com.example.demo.responses.FilterResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    public ResponseEntity<?> seeExpense(Integer page, Integer size) {
        try {
            List<Expense> response = new ArrayList<>();

            response = expenseRepository.findAll(PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "transactionDate"))).toList();

            FilterResponse filterResponse = new FilterResponse(response, "Expense list.");

            return new ResponseEntity<>(filterResponse, HttpStatus.OK);
       } catch (Exception exception){
            return new ResponseEntity<>("Something went wrong", HttpStatus.OK);
        }
    }

    public String addExpense(Expense expense){

        expense.setRecordStatus(RecordStatus.ACTIVE);

        expenseRepository.save(expense);
        return "Success";
    }
}
