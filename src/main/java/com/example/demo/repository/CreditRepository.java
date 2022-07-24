package com.example.demo.repository;

import com.example.demo.dto.Credit;
import com.example.demo.dto.Profile;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface CreditRepository extends JpaRepository<Credit, Long> {

    @Query("select c from Credit c inner join Account a inner join Profile p where p.contactNumber = :contactNumber")
    public List<Credit> findAllByAccount(@RequestParam("contactNumber") Long contactNumber);

    public List<Credit> findAllByProfile(Pageable pageable, Profile profile);
}
