package com.bank.api.Model;

import com.bank.api.Enum.LoanType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
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

    @ManyToOne
    @JoinColumn(name = "user_nic", referencedColumnName = "nic", nullable = false)
    private UserModel user;

    @Enumerated(EnumType.STRING)
    private LoanType type;
    @Positive(message = "Loan amount must be a positive number")
    private double amount;
    @Positive(message = "Loan term is must be a positive number")
    private int loanTerm;
    private boolean isLoanApproved;
    private boolean isLoanPaid;
}

