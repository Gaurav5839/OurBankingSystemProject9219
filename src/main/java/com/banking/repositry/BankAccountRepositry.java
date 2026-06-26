package com.banking.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banking.entity.BankAccount;

public interface BankAccountRepositry  extends JpaRepository<BankAccount,Long>
{
   BankAccount findByAccountNumber(String accountNumber);
}
