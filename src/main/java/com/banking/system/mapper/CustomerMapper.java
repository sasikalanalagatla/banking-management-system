package com.banking.system.mapper;

import com.banking.system.dto.AccountDto;
import com.banking.system.dto.CustomerDto;
import com.banking.system.model.Account;
import com.banking.system.model.Customer;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    @Mapping(source = "customerId", target = "customerId")
    @Mapping(source = "customerName", target = "customerName")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "address", target = "address")
    @Mapping(source = "mobileNumber", target = "mobileNumber")
    @Mapping(source = "account", target = "account")

    CustomerDto modelToDto(Customer customer);

    @Mapping(source = "customerId", target = "customerId")
    @Mapping(source = "customerName", target = "customerName")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "address", target = "address")
    @Mapping(source = "mobileNumber", target = "mobileNumber")
    @Mapping(source = "account", target = "account")
    Customer dtoToModel(CustomerDto customerDto);
}
