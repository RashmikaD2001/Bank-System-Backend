package com.bank.api.Model;

import com.bank.api.Enum.LoanType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString(exclude = "user")
public class LoanModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int loanId;

    @ManyToOne
    @JoinColumn(name = "user_nic", referencedColumnName = "nic", nullable = false)
    private UserModel user;

    @Enumerated(EnumType.STRING)
    private LoanType type;

    @Positive
    private double amount;

    @Positive
    private int loanTerm;

    @NotNull
    private Boolean isLoanApproved;

    @NotNull
    private Boolean isLoanPaid;
}

