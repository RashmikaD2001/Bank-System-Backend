package com.bank.api.Model;


import com.bank.api.Enum.AccountType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class AccountModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accId;
    @OneToOne
    @JoinColumn(name = "user_nic", referencedColumnName = "nic")
    private UserModel user;
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
    private double balance;
}
