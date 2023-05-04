package com.userauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ManitouuserauthserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManitouuserauthserviceApplication.class, args);
		 
	}

}
