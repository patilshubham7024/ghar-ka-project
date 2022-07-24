package com.example.demo.repository;

import com.example.demo.dto.Expense;
import com.example.demo.dto.Profile;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    List<Expense> findAllByProfile(PageRequest transactionDate, Profile profile);
}
