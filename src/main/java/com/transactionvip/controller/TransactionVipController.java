package com.transactionvip.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.transactionvip.model.FixedTermVipModel;
import com.transactionvip.model.TransactionVipModel;
import com.transactionvip.service.TransactionVipService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/transaction-vip")
public class TransactionVipController {
	
	@Autowired
	TransactionVipService transactionVipService;
	
	/*to see all the movements about a account number*/
	@GetMapping("/find-by/account-number/{accountNumber}")
	public Mono<TransactionVipModel> findByAccountNumber(@PathVariable String accountNumber){
		
		return transactionVipService.findByAccountNumber(accountNumber);
	}
	
	/*to see all the movements about a account number*/
	@GetMapping("/find-by/{accountNumber}")
	public Mono<FixedTermVipModel> findFixedTermVip(@PathVariable String accountNumber){
		
		return transactionVipService.findFixedTermVip(accountNumber);
	}
	
	/*to update the amount depends of Operation Type*/
	@PostMapping("/insert")
	public Mono<TransactionVipModel> insertTransactionVip(@RequestBody TransactionVipModel transactionVipModel) {
		
		return transactionVipService.insertTransactionVip(transactionVipModel);
		
	}

}
