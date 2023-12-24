package com.banking.system.service;


import com.banking.system.dto.AccountDto;
import java.util.List;
import java.util.UUID;

public interface AccountService  {
    AccountDto addAcount(AccountDto accountDto);
    void deleteAccount(UUID accountId);
    List<AccountDto> getAllAccounts();
    AccountDto getAccountById(UUID accountId);
}
