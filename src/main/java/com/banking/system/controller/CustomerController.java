package com.banking.system.controller;

import com.banking.system.dto.ApiResponse;
import com.banking.system.dto.CustomerDto;
import com.banking.system.service.imp.CustomerServiceImp;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    CustomerServiceImp customerService;

    @PostMapping("add")
    public ResponseEntity<ApiResponse<CustomerDto>> addCustomer(@RequestBody @Valid CustomerDto customerDto){
        CustomerDto cus =customerService.addCustomerAndGenerateAccount(customerDto);
        ApiResponse<CustomerDto> apiResponse= new ApiResponse<>(cus);
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }


    @GetMapping("all")
    public List<CustomerDto> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @DeleteMapping("delete/{customerId}")
    public void deleteById(@PathVariable int customerId){
         customerService.deleteById(customerId);
    }

    @GetMapping("byId/{customerId}")
    public CustomerDto getById(@PathVariable int customerId){
        return customerService.getById(customerId);
    }
}
