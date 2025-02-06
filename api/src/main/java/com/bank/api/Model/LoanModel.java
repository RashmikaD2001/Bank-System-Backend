package com.bank.api.Model;

import com.bank.api.Enum.LoanType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class LoanModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int loanId;
    @OneToOne
    @JoinColumn(name = "user_nic")
    private UserModel user;
    private LoanType type;
    private double amount;
    private boolean isLoanApproved;
}
