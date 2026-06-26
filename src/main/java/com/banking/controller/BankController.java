package com.banking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.banking.entity.BankAccount;
import com.banking.service.BankService;

@Controller
public class BankController 
{

    @Autowired
    private BankService service;

    @GetMapping("/")
    public String home() 
    {
        return "index";
    }

    
    @GetMapping("/open")
    public String openForm(Model model)
    {
        model.addAttribute("account", new BankAccount());
        return "openAccount";
    }

    @PostMapping("/open")
    public String openAccount(@ModelAttribute BankAccount account,@RequestParam String pin,Model model)
    {
        BankAccount saved = service.openAccount(account, pin);

        model.addAttribute("msg", "Account Created Successfully! Your Account Number: " + saved.getAccountNumber());
        return "index";
    }

   
    @GetMapping("/check")
    public String check() 
    {
    	return "checkAccount"; 
    }

    
    @PostMapping("/check")
    public String checkAcc(@RequestParam String accountNumber, Model model) 
    {
        model.addAttribute("account", service.findAccount(accountNumber));
        return "checkAccount";
    }

   
    @GetMapping("/deposit")
    public String depositPage() 
    {
    	return "deposit"; 
    
    }

    @PostMapping("/deposit")
    public String deposit(@RequestParam String accountNumber, @RequestParam double amount,Model model)
    {

        model.addAttribute("msg",service.deposit(accountNumber, amount));

        return "deposit";
    }

 
    @GetMapping("/withdraw")
    public String withdrawPage()
    { 
    	return "withdraw";
    }

    @PostMapping("/withdraw")
    public String withdraw(@RequestParam String accountNumber,@RequestParam String aadhaar, @RequestParam String pin,@RequestParam double amount,
                           Model model) 
    {

        model.addAttribute("msg",service.withdraw(accountNumber, aadhaar, pin, amount));

        return "withdraw";
    }
   
    
    @GetMapping("/balance")
    public String balancePage() 
    { 
    	return "balance"; 
    }

    @PostMapping("/balance")
    public String balance(@RequestParam String accountNumber, Model model)
    {
        model.addAttribute("account", service.findAccount(accountNumber));
        return "balance";
    }
}