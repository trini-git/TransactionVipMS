package com.transactionvip.repository;

import java.util.Date;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.transactionvip.model.TransactionVipModel;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface ITransactionVipRepository extends ReactiveMongoRepository<TransactionVipModel, String>{
	
	Flux<TransactionVipModel> findByAccountNumber(String accountNumber);
	
	Flux<TransactionVipModel> findByAccountNumberAndCreatedAtBetween (String accountNumber, String from, String to);
}
