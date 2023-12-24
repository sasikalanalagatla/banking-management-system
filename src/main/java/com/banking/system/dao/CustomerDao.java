package com.banking.system.dao;

import com.banking.system.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDao extends JpaRepository<Customer,Integer> {
    boolean existsByMobileNumber(long mobileNumber);
    boolean existsByEmail(String email);
}
