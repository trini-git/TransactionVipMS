package com.transactionvip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class TransactionVipMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransactionVipMsApplication.class, args);
	}

}
