package com.banking.system.dao;

import com.banking.system.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface AccountDao extends JpaRepository<Account, UUID> {
}
