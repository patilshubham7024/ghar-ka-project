package com.example.demo.service;

import com.example.demo.dto.Account;
import com.example.demo.dto.Expense;
import com.example.demo.dto.Profile;
import com.example.demo.enums.RecordStatus;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.ExpenseRepository;
import com.example.demo.repository.ProfileRepository;
import com.example.demo.requests.AddExpense;
import com.example.demo.responses.FilterResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private ProfileRepository profileRepository;

    public ResponseEntity<?> seeExpense(Integer page, Integer size, Long contactNumber) {
        try {
            Profile profile = profileRepository.findById(contactNumber).get();
            List<Expense> response = expenseRepository.findAllByProfile(
                    PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "transactionDate")),
                    profile);
            for(Expense expense : response){
                expense.setAccount(null);
            }
            FilterResponse filterResponse = new FilterResponse(response, "Expense list.");

            return new ResponseEntity<>(filterResponse, HttpStatus.OK);
       } catch (Exception exception){
            return new ResponseEntity<>("Something went wrong", HttpStatus.BAD_REQUEST);
        }
    }

    public String addExpense(AddExpense expense){
        try {
            Expense expense1 = new Expense();
            expense1.setRecordStatus(RecordStatus.ACTIVE);
            expense1.setRecordCreatedDate(LocalDateTime.now());

            Account account = accountRepository.findById(expense.getAccountId()).get();
            account.setAmount(account.getAmount().subtract(expense.getAmount()));
            expense1.setAccount(account);
            Profile profile = profileRepository.findById(expense.getContactNumber()).get();
            expense1.setProfile(profile);
            expenseRepository.save(expense1);
            return "Success";
        } catch (Exception exception){
            exception.printStackTrace();
            return null;
        }
    }
}
