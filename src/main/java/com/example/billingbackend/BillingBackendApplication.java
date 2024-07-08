package com.example.billingbackend;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class BillingBackendApplication {


	public static void main(String[] args) {
		SpringApplication.run(BillingBackendApplication.class, args);

	}

//	when the user login
//	login Controller ----> UsernamePasswordAuthenticationToken ---->  authenticationManager ----> generate jwd token

// after login
// SpringSecurityConfig ---->  JwtTokenFilter ---->   UsernamePasswordAuthenticationToken

}


