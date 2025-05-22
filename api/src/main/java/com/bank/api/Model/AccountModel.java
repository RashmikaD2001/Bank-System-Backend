package com.bank.api.Model;


import com.bank.api.Enum.AccountType;
import jakarta.persistence.*;
import jakarta.validation.constraints.PositiveOrZero;
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
    @ManyToOne
    @JoinColumn(name = "user_nic", referencedColumnName = "nic", nullable = false)
    private UserModel user;
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
    @PositiveOrZero
    private double balance;
    private boolean isAccountActive;

    public int getAccId(){
        return accId;
    }
}
