package com.bank.api.Model;


import com.bank.api.Enum.AccountType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString(exclude = "user")
public class AccountModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accId;

    @ManyToOne
    @JoinColumn(name = "user_nic", referencedColumnName = "nic", nullable = false)
    private UserModel user;

    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    @Min(500)
    private double balance;

    @NotNull
    private Boolean isAccountActive;
}
