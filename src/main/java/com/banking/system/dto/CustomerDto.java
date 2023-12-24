package com.banking.system.dto;

import com.banking.system.model.Account;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class CustomerDto {

    private int customerId;
    @NotNull(message="User should not be null")
    private String customerName;
    @Email(message = "invalid email address")
    private String email;



    private String address;
    @NotNull
    private long mobileNumber;
    private Account account;
}
