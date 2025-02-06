package com.bank.api.Service;

import com.bank.api.Model.AccountModel;
import com.bank.api.Repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    private AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<AccountModel> getAllAccounts() {
        return accountRepository.findAll();
    }

    public AccountModel getAccountById(int id) {
        return accountRepository.findById(id).get();
    }

    public void addAccount(AccountModel account) {
        accountRepository.save(account);
    }

    public void deleteAccountById(int id) {
        accountRepository.deleteById(id);
    }

    public void updateAccount(AccountModel account) {
        if(getAccountById(account.getAccId()) != null) {
            accountRepository.save(account);
        }else{
            throw new RuntimeException("No account for given id " + account.getAccId());
        }
    }

    public List<AccountModel> getAccountUserNIC(String nic) {
        return accountRepository.findAccountByUserNIC(nic);
    }
}
