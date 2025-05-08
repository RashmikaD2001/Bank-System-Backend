package com.bank.api.Controller;

import com.bank.api.Model.AccountModel;
import com.bank.api.Service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public List<AccountModel> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @GetMapping("/{id}")
    public Optional<AccountModel> getAccountById(@PathVariable int id) {
        return accountService.getAccountById(id);
    }

    @GetMapping("/nic/{id}")
    public List<AccountModel > getAccountByNic(@PathVariable String id) {
        return accountService.getAccountUserNIC(id);
    }

    @PostMapping("/add")
    public void addAccount(@RequestBody AccountModel account) {
        accountService.addAccount(account);
    }

    @PutMapping("/add")
    public void updateAccount(@RequestBody AccountModel account) {
        accountService.updateAccount(account);
    }

    @DeleteMapping
    public void deleteAccount(@RequestBody int id) {
        accountService.deleteAccountById(id);
    }
}
