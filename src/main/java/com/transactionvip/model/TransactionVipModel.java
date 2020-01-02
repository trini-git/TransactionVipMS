package com.transactionvip.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "transaction_vip")
public class TransactionVipModel {

  @Id
  private String id;
  private String accountNumber;
  private String typeOperation;
  private Double amount;
  private Double beforeAmount;
  private Double afterAmount;
  private Double chargeAmount;
  private String createdAt;

  public TransactionVipModel() {
	  
	SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss"); 
    this.createdAt = formatter.format(new Date());
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getAccountNumber() {
    return accountNumber;
  }

  public void setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
  }

  public String getTypeOperation() {
    return typeOperation;
  }

  public void setTypeOperation(String typeOperation) {
    this.typeOperation = typeOperation;
  }

  public Double getAmount() {
    return amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }

  public Double getBeforeAmount() {
    return beforeAmount;
  }

  public void setBeforeAmount(Double beforeAmount) {
    this.beforeAmount = beforeAmount;
  }

  public Double getAfterAmount() {
    return afterAmount;
  }

  public void setAfterAmount(Double afterAmount) {
    this.afterAmount = afterAmount;
  }

  public Double getChargeAmount() {
    return chargeAmount;
  }

  public void setChargeAmount(Double chargeAmount) {
    this.chargeAmount = chargeAmount;
  }

public String getCreatedAt() {
	return createdAt;
}

public void setCreatedAt(String createdAt) {
	this.createdAt = createdAt;
}

  

}