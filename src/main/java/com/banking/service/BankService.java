package com.banking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.banking.entity.BankAccount;
import com.banking.repositry.BankAccountRepositry;

@Service
public class BankService
{
	
	@Autowired	
    private  BankAccountRepositry repo; 
	
	@Autowired
	private BCryptPasswordEncoder encoder;

    // OPEN ACCOUNT
  	 
    public BankAccount openAccount(BankAccount account, String pin)
    {

        account.setAccountNumber("ACC" + System.currentTimeMillis());

      
        String hash = encoder.encode(pin);
        account.setPinHash(hash);

        account.setBalance(0);
        
        return repo.save(account);
    }

    // FIND
    public BankAccount findAccount(String accNo) 
    {
        return repo.findByAccountNumber(accNo);
    }

    // DEPOSIT
    public String deposit(String accNo, double amt)
    {
        BankAccount acc = findAccount(accNo);

        if (acc == null)
            return "Account Not Found";

        acc.setBalance(acc.getBalance() + amt);
        repo.save(acc);

        return "Deposit Successful!";
    }

    // WITHDRAW (SECURE)
    public String withdraw(String accNo, String aadhaar, String pin, double amount) 
    {

        BankAccount acc = findAccount(accNo);

        if (acc == null)
            return "Account Not Found!";

        if (!acc.getAadhaar().equals(aadhaar))
            return "Aadhaar Incorrect!";

        // hashed PIN compare
        if (!encoder.matches(pin, acc.getPinHash()))
            return "Incorrect PIN!";

        if (acc.getBalance() < amount)
            return "Insufficient Balance!";

        acc.setBalance(acc.getBalance() - amount);
        repo.save(acc);

        return  "Withdraw Successful!"; 
    }
}
	
	
