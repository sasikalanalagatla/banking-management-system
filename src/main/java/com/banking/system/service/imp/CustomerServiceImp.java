package com.banking.system.service.imp;

import com.banking.system.dao.AccountDao;
import com.banking.system.dao.CustomerDao;
import com.banking.system.dto.CustomerDto;
import com.banking.system.exception.AlreadyExistException;
import com.banking.system.exception.NotFoundException;
import com.banking.system.mapper.CustomerMapper;
import com.banking.system.model.Account;
import com.banking.system.model.Customer;
import com.banking.system.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImp implements CustomerService {
    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private AccountDao accountDao;
    private final CustomerMapper customerMapper = CustomerMapper.INSTANCE;

    @Override
    public CustomerDto addCustomerAndGenerateAccount(CustomerDto customerDto) {
        if(customerDao.existsByEmail(customerDto.getEmail())){
            throw new AlreadyExistException("Email is already in use");
        }else if(customerDao.existsByMobileNumber(customerDto.getMobileNumber())){
            throw new AlreadyExistException("Mobile Number is already in use");
        }
        Customer customer = customerMapper.dtoToModel(customerDto);
        Customer savedCustomer = customerDao.save(customer);

        Account account = new Account();
        account.setAccountId(UUID.randomUUID());
        account.setBalance(0.0f);
        accountDao.save(account);
        return customerMapper.modelToDto(savedCustomer);
    }


    @Override
    public List<CustomerDto> getAllCustomers(){
        List<Customer> customers = customerDao.findAll();
        List<CustomerDto> customerDtos = customers.stream()
                .map(customerMapper::modelToDto).collect(Collectors.toList());
        return customerDtos;
    }


    @Override
    public void deleteById(Integer customerId) {
         customerDao.deleteById(customerId);
    }

    public CustomerDto getById(Integer customerId) {
        Customer customer = customerDao.findById(customerId)
                .orElseThrow(() -> new NotFoundException("Customer not found"));

        return customerMapper.modelToDto(customer);
    }
}
