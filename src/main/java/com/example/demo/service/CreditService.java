package com.example.demo.service;

import com.example.demo.dto.Credit;
import com.example.demo.enums.RecordStatus;
import com.example.demo.repository.CreditRepository;
import com.example.demo.responses.FilterResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CreditService {

    @Autowired
    private CreditRepository creditRepository;

    public ResponseEntity<?> seeCredit(Integer page, Integer size) {
        try {
            List<Credit> response = new ArrayList<>();

            response = creditRepository.findAll(PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "transactionDate"))).toList();

            FilterResponse filterResponse = new FilterResponse(response, "Credit list.");

            return new ResponseEntity<>(filterResponse, HttpStatus.OK);
        } catch (Exception exception){
            return new ResponseEntity<>("Something went wrong", HttpStatus.OK);
        }
    }

    public String addCredit(Credit credit){

        credit.setRecordStatus(RecordStatus.ACTIVE);

        creditRepository.save(credit);
        return "Success";
    }
}
