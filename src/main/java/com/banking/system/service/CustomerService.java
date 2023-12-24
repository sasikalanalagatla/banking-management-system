package com.banking.system.service;

import com.banking.system.dto.CustomerDto;

import java.util.List;

public interface CustomerService {
    CustomerDto addCustomerAndGenerateAccount(CustomerDto customerDto);
    List<CustomerDto> getAllCustomers();
    void deleteById(Integer customerId);
    CustomerDto getById(Integer customerId);
}
