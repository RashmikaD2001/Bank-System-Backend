package com.bank.api.Repository;

import com.bank.api.Model.LoanModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<LoanModel, Integer> {

    List<LoanModel> findLoansByUser_NIC(String nic);
}
