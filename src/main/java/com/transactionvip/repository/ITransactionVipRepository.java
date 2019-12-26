package com.transactionvip.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.transactionvip.model.TransactionVipModel;

import reactor.core.publisher.Mono;

@Repository
public interface ITransactionVipRepository extends ReactiveMongoRepository<TransactionVipModel, String>{
	
	Mono<TransactionVipModel> findByAccountNumber(String accountNumber);
}
