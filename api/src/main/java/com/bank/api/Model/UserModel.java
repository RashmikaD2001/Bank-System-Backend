package com.bank.api.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String nic;
    private String fname;
    private String lname;
    private String email;
    private String telNo;
    private int noOfDependents;
    private boolean graduated;
    private boolean selfEmployed;
    private double annualIncome;
    private double creditScore;
    private double assets;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<LoanModel> loans = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<AccountModel> accounts = new ArrayList<>();
}

