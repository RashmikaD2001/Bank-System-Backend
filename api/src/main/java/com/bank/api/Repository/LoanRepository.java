package com.bank.api.Repository;

import com.bank.api.Model.LoanModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<LoanModel, Integer> {

    List<LoanModel> findLoansByUser_Nic(String nic);

    // Find unpaid loans
    List<LoanModel> findByIsLoanPaidFalse();

    // Find paid loans
    List<LoanModel> findByIsLoanPaidTrue();

    List<LoanModel> findByIsLoanApprovedFalse();

    List<LoanModel> findByIsLoanApprovedTrue();
}
