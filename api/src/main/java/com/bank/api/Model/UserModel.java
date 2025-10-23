package com.bank.api.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString(exclude = {"loans", "accounts"})
public class UserModel {

    @Id
    private String nic;

    @NotBlank(message = "First name is mandatory")
    private String fname;

    @NotBlank(message = "Last name is mandatory")
    private String lname;

    @Email
    private String email;

    @Size(min = 10, max = 10)
    private String telNo;

    @PositiveOrZero
    private int noOfDependents;

    @NotNull
    private Boolean graduated;

    @NotNull
    private Boolean selfEmployed;

    @PositiveOrZero
    private double annualIncome;

    @Min(-1000)
    @Max(1000)
    private double creditScore;

    @PositiveOrZero
    private double assets;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<LoanModel> loans = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<AccountModel> accounts = new ArrayList<>();
}

