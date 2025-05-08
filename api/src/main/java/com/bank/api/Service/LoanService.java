package com.bank.api.Service;

import com.bank.api.Model.LoanModel;
import com.bank.api.Repository.LoanRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoanService {

    private final LoanRepository loanRepository;

    public LoanService(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public List<LoanModel> getAllLoans() {
        return loanRepository.findAll();
    }

    public Optional<LoanModel> getLoanById(int id) {
        return loanRepository.findById(id);
    }

    public void addLoan(LoanModel loan) {
        loanRepository.save(loan);
    }

    public void deleteLoanById(int id) {
        loanRepository.deleteById(id);
    }

    public void updateLoan(LoanModel loan) {
        loanRepository.save(loan);
    }

    public List<LoanModel> getLoansByUserNIC(String nic) {
        return loanRepository.findLoansByUser_Nic(nic);
    }

    // New method to get all unpaid loans
    public List<LoanModel> getUnpaidLoans() {
        return loanRepository.findByIsLoanPaidFalse();
    }

    // New method to get all paid loans
    public List<LoanModel> getPaidLoans() {
        return loanRepository.findByIsLoanPaidTrue();
    }

    public List<LoanModel> getApprovedLoans() {
        return loanRepository.findByIsLoanApprovedTrue();
    }

    public List<LoanModel> getRejectedLoans() {
        return loanRepository.findByIsLoanPaidFalse();
    }
}
