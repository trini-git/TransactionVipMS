package com.transactionvip.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.transactionvip.model.FixedTermVipModel;
import com.transactionvip.model.TransactionVipModel;
import com.transactionvip.repository.ITransactionVipRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TransactionVipService implements ITransactionVipService {

  @Autowired
  ITransactionVipRepository iTransactionVipRepository;
  
  @Autowired
  @Qualifier("bankFixedTermAccountVip")
  WebClient client;

  FixedTermVipModel fixedTermVipModel = new FixedTermVipModel();
  
  @Override
  public Flux<TransactionVipModel> findByAccountNumber(String accountNumber) {

    return iTransactionVipRepository.findByAccountNumber(accountNumber);
  }

  @Override
  public Mono<TransactionVipModel> insertTransactionVip(TransactionVipModel transactionVipModel) {

    fixedTermVipModel.setAccountNumber(transactionVipModel.getAccountNumber());
    fixedTermVipModel.setCurrentAmount(transactionVipModel.getAmount());

    Mono<FixedTermVipModel> fixedTermVip = findFixedTermVip(transactionVipModel.getAccountNumber());

    return fixedTermVip.flatMap(x -> {

      if (x.getMaxOfMovement() <= x.getNumberOfMovement()) {
        transactionVipModel.setChargeAmount(x.getChargeAmount());
      } else {
        transactionVipModel.setChargeAmount(0.0);
      }

      if (transactionVipModel.getTypeOperation().equalsIgnoreCase("R")) {
        transactionVipModel.setBeforeAmount(x.getCurrentAmount());
        transactionVipModel.setAmount(transactionVipModel.getAmount());
        transactionVipModel.setAfterAmount(x.getCurrentAmount() - (transactionVipModel.getAmount() + transactionVipModel.getChargeAmount()));

        return updateAmountRetire(fixedTermVipModel)

.flatMap(y -> {
  return iTransactionVipRepository.save(transactionVipModel);
});

      } else if (transactionVipModel.getTypeOperation().equalsIgnoreCase("D")) {

        transactionVipModel.setBeforeAmount(x.getCurrentAmount());
        transactionVipModel.setAmount(transactionVipModel.getAmount());
        transactionVipModel.setAfterAmount(x.getCurrentAmount() + (transactionVipModel.getAmount() - transactionVipModel.getChargeAmount()));
        return updateAmountDeposite(fixedTermVipModel)

.flatMap(z -> {
  return iTransactionVipRepository.save(transactionVipModel);
});

      }
      return Mono.empty();
    });
  }
  
  /* Microservice that connects */
  public Mono<FixedTermVipModel> updateAmountRetire(FixedTermVipModel fixedTermVipModel) {
    return client.put()
.uri("/update-retire")
.accept(MediaType.APPLICATION_JSON_UTF8)
.contentType(MediaType.APPLICATION_JSON_UTF8)
.syncBody(fixedTermVipModel)
.retrieve()
.bodyToMono(FixedTermVipModel.class)
.switchIfEmpty(Mono.empty());
  }

  /* Microservice that connects */
  public Mono<FixedTermVipModel> updateAmountDeposite(FixedTermVipModel fixedTermVipModel) {
    return client.put()
.uri("/update-deposite")
.accept(MediaType.APPLICATION_JSON_UTF8)
.contentType(MediaType.APPLICATION_JSON_UTF8)
.syncBody(fixedTermVipModel)
.retrieve()
.bodyToMono(FixedTermVipModel.class)
.switchIfEmpty(Mono.empty());
  }

  /* Microservice that connects */
  public Mono<FixedTermVipModel> findFixedTermVip(String accountNumber) {
    Map<String, Object> param = new HashMap<String, Object>();
    param.put("accountNumber", accountNumber);
    return client.get()
.uri("/find-by/{accountNumber}",param)
.accept(MediaType.APPLICATION_JSON_UTF8)
.retrieve()
.bodyToMono(FixedTermVipModel.class)
.switchIfEmpty(Mono.empty());
  }

@Override
public Flux<TransactionVipModel> findByAccountNumberAndCreatedAtBetween(String accountNumber, String from, String to) {
	
	return iTransactionVipRepository.findByAccountNumberAndCreatedAtBetween(accountNumber, from, to)
		.filter(x -> x.getChargeAmount() > 0.0);
				
}

}
