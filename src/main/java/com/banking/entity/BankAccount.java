package com.banking.entity;

import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class BankAccount
{
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private long id;
  @Column
  private String accountNumber;
  @Column
  private String name;
  @Column
  private String  aadhaar;
  @Column
  private String pinHash;
  @Column
  private double balance;
  
  public long getId() {
	return id;
}
  public void setId(long id) {
	this.id = id;
  }
  public String getAccountNumber() {
	return accountNumber;
  }
  public void setAccountNumber(String accountNumber) {
	this.accountNumber = accountNumber;
  }
  public String getName() {
	return name;
  }
  public void setName(String name) {
	this.name = name;
  }
  public String getAadhaar() {
	return aadhaar;
  }
  public void setAadhaar(String aadhaar) {
	this.aadhaar = aadhaar;
  }
  public String getPinHash() {
	return pinHash;
  }
  public void setPinHash(String pinHash) {
	this.pinHash = pinHash;
  }
  public double getBalance() {
	return balance;
  }
  public void setBalance(double balance) {
	this.balance = balance;
  }
  public LocalDate getOpenDate() {
	return openDate;
  }
  public void setOpenDate(LocalDate openDate) {
	this.openDate = openDate;
  }
  private LocalDate openDate;
}
