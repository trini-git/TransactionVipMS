package com.transactionvip.service;

import com.transactionvip.model.TransactionVipModel;

import reactor.core.publisher.Mono;

public interface ITransactionVipService {

	Mono<TransactionVipModel> findByAccountNumber(String accountNumber);
	Mono<TransactionVipModel> insertTransactionVip(TransactionVipModel transactionVipModel);
}
