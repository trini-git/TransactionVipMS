package com.transactionvip.model;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

public class FixedTermVipModel {

	private String id;
	
	private String accountNumber;

	private String type;

	private Double startingAmount;

	private Double currentAmount;

	private Double finalMonthAmount;

	private Double chargeAmount;

	private int maxOfMovement;

	private int numberOfMovement;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd@HH:mm:ss")
	private Date createdAt;

	private String status;

	public FixedTermVipModel() {

		this.createdAt = new Date();
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getStartingAmount() {
		return startingAmount;
	}

	public void setStartingAmount(Double startingAmount) {
		this.startingAmount = startingAmount;
	}

	public Double getCurrentAmount() {
		return currentAmount;
	}

	public void setCurrentAmount(Double currentAmount) {
		this.currentAmount = currentAmount;
	}

	public Double getFinalMonthAmount() {
		return finalMonthAmount;
	}

	public void setFinalMonthAmount(Double finalMonthAmount) {
		this.finalMonthAmount = finalMonthAmount;
	}

	public Double getChargeAmount() {
		return chargeAmount;
	}

	public void setChargeAmount(Double chargeAmount) {
		this.chargeAmount = chargeAmount;
	}

	public int getMaxOfMovement() {
		return maxOfMovement;
	}

	public void setMaxOfMovement(int maxOfMovement) {
		this.maxOfMovement = maxOfMovement;
	}

	public int getNumberOfMovement() {
		return numberOfMovement;
	}

	public void setNumberOfMovement(int numberOfMovement) {
		this.numberOfMovement = numberOfMovement;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
