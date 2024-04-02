package com.example.billingbackend.security;

import com.example.billingbackend.entity.UserEntity;
import com.example.billingbackend.repository.UsersRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomAuthenticationManager implements AuthenticationManager {
    UsersRepository UsersRepository;

    @Override
    public Authentication authenticate(Authentication authenticationToken) throws AuthenticationException {

        System.out.println("authenticationToken   >> " + authenticationToken );
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


//        UserEntity user = UsersRepository.findByUsername(username).get();


//        System.out.println("user from db   >> " + user );

        return true;
    }
}
