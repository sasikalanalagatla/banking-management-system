package com.banking.system.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;
    private String customerName;
    private String email;
    private long mobileNumber;
    private String address;
    @OneToOne
    @JoinColumn(name = "accountId")
    private Account account;

    public Customer(String customerName, String email, long mobileNumber, String address, Account account) {
        this.customerName = customerName;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.address = address;
        this.account = account;
    }

}
