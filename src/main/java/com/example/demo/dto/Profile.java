package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.List;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Profile implements Serializable {
    @Id
    @Column(name = "contact_number")
    @Min(1000000000)
    private Long contactNumber;

    @Column
    private String name;

    @Column(unique = true)
    private String username;

    @Column
    private String role;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Account> accounts;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Credit> credits;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Expense> expenses;

    public Profile(Long contactNumber, String name, String username, String role) {
        this.contactNumber = contactNumber;
        this.name = name;
        this.username = username;
        this.role = role;
    }
}
