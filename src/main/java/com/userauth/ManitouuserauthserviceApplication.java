package com.userauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@SpringBootApplication
@EnableFeignClients
public class ManitouuserauthserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManitouuserauthserviceApplication.class, args);
		 
	}
	@Bean
	public UserDetailsService getuserdeDetailsService() {
		return new UserDetailsService() {
			
			@Override
			public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
				// TODO Auto-generated method stub
				return null;
			}
		};
	}

}
