package com.bank.api.Service;

import com.bank.api.Model.AccountModel;
import com.bank.api.Repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    private AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<AccountModel> getAllAccounts() {
        return accountRepository.findAll();
    }

    public Optional<AccountModel> getAccountById(int id) {
        return accountRepository.findById(id);
    }

    public void addAccount(AccountModel account) {
        accountRepository.save(account);
    }

    public void deleteAccountById(int id) {
        accountRepository.deleteById(id);
    }

    public void updateAccount(AccountModel account) {
        accountRepository.save(account);
    }

    public List<AccountModel> getAccountUserNIC(String nic) {
        return accountRepository.findAccountByUserNic(nic);
    }

    // FIX: Renamed methods and corrected the repository calls
    // Method to get all inactive accounts
    public List<AccountModel> getInactiveAccounts() {
        return accountRepository.findByIsAccountActiveFalse();
    }

    // Method to get all active accounts
    public List<AccountModel> getActiveAccounts() {
        return accountRepository.findByIsAccountActiveTrue();
    }
}
