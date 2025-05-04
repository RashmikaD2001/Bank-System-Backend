package com.bank.api.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
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
    private String nic;
    private String fname;
    private String lname;
    private String email;
    private String telNo;
    @Positive(message = "Number of dependents are positive")
    private int noOfDependents;
    private boolean graduated;
    private boolean selfEmployed;
    @Positive(message = "Annual Income is positive")
    private double annualIncome;
    private double creditScore;
//    private double residentialAssetValue;
//    private double commercialAssetValue;
//    private double luxuryAssetValue;
//    private double bankAssetValue;
    private double assets;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<LoanModel> loans = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<AccountModel> accounts = new ArrayList<>();
}

