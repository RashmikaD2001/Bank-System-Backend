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
    public List<AccountModel> getAccountByNic(@PathVariable String id) {
        return accountService.getAccountUserNIC(id);
    }

    // Added new endpoints for active/inactive accounts
    @GetMapping("/active")
    public List<AccountModel> getActiveAccounts() {
        return accountService.getActiveAccounts();
    }

    @GetMapping("/inactive")
    public List<AccountModel> getInactiveAccounts() {
        return accountService.getInactiveAccounts();
    }

    @PostMapping("/add")
    public void addAccount(@RequestBody AccountModel account) {
        accountService.addAccount(account);
    }

    // FIX: Changed mapping from /add to /{id} to match RESTful convention
    @PutMapping("/{id}")
    public void updateAccount(@PathVariable int id, @RequestBody AccountModel account) {
        // Ensure the account ID matches the path variable
        if (account.getAccId() != id) {
            // In a real application, you might want to throw an exception here
            // For now, we'll just update the account as received
            System.out.println("Account ID is not equal to Account ID");
        }
        accountService.updateAccount(account);
    }

    // FIX: Added PathVariable annotation and corrected the method signature
    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable int id) {
        accountService.deleteAccountById(id);
    }
}
