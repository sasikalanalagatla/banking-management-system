package com.banking.system.controller;

import com.banking.system.dto.AccountDto;
import com.banking.system.service.imp.AccountServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class AccountController {

    @Autowired
    AccountServiceImp accountService;

    @GetMapping("/accounts")
    public List<AccountDto> getAllAccounts(){
        return accountService.getAllAccounts();
    }

    @GetMapping("accounts/{accountId}")
    public AccountDto getAccountbyId(@PathVariable UUID accountId){
        return accountService.getAccountById(accountId);
    }

    @DeleteMapping("/accounts/{accountId}")
    public void deleteAccount(UUID accountId){
        accountService.deleteAccount(accountId);
    }
}
