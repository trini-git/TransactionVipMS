package com.transactionvip.service;

import java.util.Date;

import com.transactionvip.model.TransactionVipModel;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ITransactionVipService {

	Flux<TransactionVipModel> findByAccountNumber(String accountNumber);
	Mono<TransactionVipModel> insertTransactionVip(TransactionVipModel transactionVipModel);
	Flux<TransactionVipModel> findByAccountNumberAndCreatedAtBetween (String accountNumber, String from, String to);
}
