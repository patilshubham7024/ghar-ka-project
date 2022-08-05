package com.example.demo.service;

import com.example.demo.dto.Account;
import com.example.demo.dto.Profile;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.ProfileRepository;
import com.example.demo.responses.DashboardAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private ProfileRepository profileRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public String addAccount(Account account){
        try {
            account.setProfile(
            profileRepository.findById(account.getProfile().getContactNumber()).orElse(null)
            );
            accountRepository.save(account);
            return "Account added.";
        } catch (Exception exception){
            return "Something went wrong.";
        }
    }

    public ResponseEntity<DashboardAccount> getAccount(Long accountId) {
        try{
            Account account = accountRepository.findById(accountId).get();
            return new ResponseEntity<>(
            		new DashboardAccount(
            				account.getAccountId(),
            				account.getAccountName(),
            				account.getAmount(),
            				account.getDescription(),
            				account.getProfile().getContactNumber()),
                    HttpStatus.OK);
        }catch (Exception exception){
            return null;
        }
    }

    public List<DashboardAccount> getAllAccounts(Long contactNumber){
        try {
            CriteriaBuilder builder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Account> query = builder.createQuery(Account.class);
            Root<Account> root = query.from(Account.class);
            Join<Account, Profile> join = root.join("profile");

            query.where(builder.equal(join.get("contactNumber"), contactNumber));

            query.select(root);
            TypedQuery<Account> query1 = entityManager.createQuery(query);

                   List<Account> list = query1.getResultList();
            List<DashboardAccount> account = new ArrayList<>();
                    for(Account o : list){
                    account.add(
                    		new DashboardAccount(
                    				o.getAccountId(),
                    				o.getAccountName(),
                    				o.getAmount(),
                    				null,
                    				null));
            }
            return account;
        }catch (Exception exception){
            exception.printStackTrace();
            return null;
        }
    }

    public BigDecimal total(Long contactNumber){
        try {
            Profile profile = profileRepository.findById(contactNumber).get();
            List<Account> accounts = accountRepository.findAllByProfile(profile);
            BigDecimal total = new BigDecimal(0);
            accounts.stream().map(account -> total.add(account.getAmount()));
            return total;
        }catch (Exception exception){
            return null;
        }
    }
}
