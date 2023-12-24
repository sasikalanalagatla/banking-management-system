package com.banking.system.service.imp;

import com.banking.system.dao.AccountDao;
import com.banking.system.dto.AccountDto;
import com.banking.system.exception.NotFoundException;
import com.banking.system.mapper.AccountMapper;
import com.banking.system.model.Account;
import com.banking.system.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AccountServiceImp implements AccountService {
    @Autowired
    private AccountDao accountDao;
    private final AccountMapper accountMapper = AccountMapper.INSTANCE;
    @Override
    public AccountDto addAcount(AccountDto accountDto) {
        Account account = accountMapper.dtoToModel(accountDto);
        Account savedAccount = accountDao.save(account);
        return accountMapper.modelToDto(savedAccount);
    }
    @Override
    public void deleteAccount(UUID accountId) {
        accountDao.deleteById(accountId);
    }

    @Override
    public List<AccountDto> getAllAccounts() {
        List<Account> accounts = accountDao.findAll();
        return accounts.stream().map(accountMapper::modelToDto).collect(Collectors.toList());
    }

    @Override
    public AccountDto getAccountById(UUID accountId) {
        Account account = accountDao.findById(accountId).orElseThrow(
                ()->new NotFoundException("account not found"));
        return accountMapper.modelToDto(account);
    }
}
