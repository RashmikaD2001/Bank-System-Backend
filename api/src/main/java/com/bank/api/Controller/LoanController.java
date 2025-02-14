package com.bank.api.Controller;

import com.bank.api.Model.LoanModel;
import com.bank.api.Service.LoanService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loan")
public class LoanController {

    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @GetMapping
    public List<LoanModel> getAllLoans(){
        return loanService.getAllLoans();
    }

    @GetMapping("/paid")
    public List<LoanModel> getPaidLoans(){
        return loanService.getPaidLoans();
    }

    @GetMapping("/unpaid")
    public List<LoanModel> getUnpaidLoans(){
        return loanService.getUnpaidLoans();
    }

    @GetMapping("/approved")
    public List<LoanModel> getApprovedLoans(){
        return loanService.getApprovedLoans();
    }

    @GetMapping("/unapproved")
    public List<LoanModel> getUnapprovedLoans(){
        return loanService.getRejectedLoans();
    }

    @GetMapping("/{id}")
    public LoanModel getLoanById(@PathVariable int id){
        return loanService.getLoanById(id);
    }

    @GetMapping("/nic/{id}")
    public List<LoanModel> getLoanByNic(@PathVariable String id){
        return loanService.getLoansByUserNIC(id);
    }

    @PostMapping("/add")
    public void addLoan(@RequestBody LoanModel loan){
        loanService.addLoan(loan);
    }

    @PutMapping("/{id}")
    public void updateLoan(@RequestBody LoanModel loan){
        loanService.updateLoan(loan);
    }

    @DeleteMapping("/{id}")
    public void deleteLoan(@PathVariable int id){
        loanService.deleteLoanById(id);
    }
}
