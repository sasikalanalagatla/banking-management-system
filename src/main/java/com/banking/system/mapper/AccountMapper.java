package com.banking.system.mapper;

import com.banking.system.dto.AccountDto;
import com.banking.system.model.Account;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AccountMapper {

    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);
    @Mapping(source = "customer", target = "customer")
    @Mapping(source = "accountId", target = "accountId")
    @Mapping(source = "balance", target = "balance")

    AccountDto modelToDto(Account account);
    @Mapping(source = "customer", target = "customer")
    @Mapping(source = "accountId", target = "accountId")
    @Mapping(source = "balance", target = "balance")
    Account dtoToModel(AccountDto accountDto);
}
