package com.example.demo.repository;

import com.example.demo.dto.Account;
import com.example.demo.dto.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    List<Account> findAllByProfile(Profile profile);
}
