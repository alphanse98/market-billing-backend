package com.example.billingbackend.security;

import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomAuthenticationManager implements AuthenticationManager {

    @Override
    public Authentication authenticate(Authentication authenticationToken) throws AuthenticationException {

//             get username and password from params
        String username = authenticationToken.getName();
        String password = authenticationToken.getCredentials().toString();

        if (isValidUser(username, password)) {
            return new UsernamePasswordAuthenticationToken(username, password); // sent security
        } else {
            throw new AuthenticationException("Invalid credentials") {
            };
        }



//        return null;
    }

    private boolean isValidUser(String username, String password) {
        System.out.println(" pass >> " + password);
        System.out.println("username  >> " + username );
        return true;
    }
}
