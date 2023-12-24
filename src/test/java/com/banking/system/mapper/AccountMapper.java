package com.banking.system.mapper;

import com.banking.system.dto.AccountDto;
import com.banking.system.model.Account;

public interface AccountMapper {

    AccountDto modelToDto(Account account);
    Account dtoToModel(AccountDto accountDto);
}
