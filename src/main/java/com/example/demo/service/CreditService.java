package com.example.demo.service;

import com.example.demo.dto.Account;
import com.example.demo.dto.Credit;
import com.example.demo.dto.Profile;
import com.example.demo.enums.RecordStatus;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.CreditRepository;
import com.example.demo.repository.ProfileRepository;
import com.example.demo.requests.AddCredit;
import com.example.demo.responses.FilterResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CreditService {

    @Autowired
    private CreditRepository creditRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private ProfileRepository profileRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public ResponseEntity<?> seeCredit(Integer page, Integer size, Long contactNumber) {
        try {
            Profile profile = profileRepository.findById(contactNumber).get();
            List<Credit> response = creditRepository.findAllByProfile(
                    PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "transactionDate")),
                    profile);
            for(Credit credit: response){
                credit.setAccount(null);
            }
            FilterResponse filterResponse = new FilterResponse(response, "Credit list.");

            return new ResponseEntity<>(filterResponse, HttpStatus.OK);
        } catch (Exception exception){
            return new ResponseEntity<>("Something went wrong", HttpStatus.BAD_REQUEST);
        }
    }

    public String addCredit(AddCredit credit){
        try {
            Credit credit1 = new Credit();
            credit1.setRecordStatus(RecordStatus.ACTIVE);
            credit1.setRecordCreatedDate(LocalDateTime.now());

            Account account = accountRepository.findById(credit.getAccountId()).get();
            account.setAmount(account.getAmount().add(credit.getAmount()));
            credit1.setAccount(account);
            credit1.setDescription(credit.getDescription());
            credit1.setTransactionDate(credit.getTransactionDate());

            creditRepository.save(credit1);
            return "Success";
        } catch (Exception exception){
            exception.printStackTrace();
            return null;
        }
    }
}
