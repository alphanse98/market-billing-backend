package com.example.billingbackend.security;

import com.example.billingbackend.entity.UserEntity;
import com.example.billingbackend.repository.UsersRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomAuthenticationManager implements AuthenticationManager {
    private UsersRepository UsersRepository;
    private PasswordEncoder PasswordEncoder;

    @Override
    public Authentication authenticate(Authentication authenticationToken) throws AuthenticationException {

//        System.out.println("authenticationToken   >> " + authenticationToken );
//             get username and password from params
        String username = authenticationToken.getName();
        String password = authenticationToken.getCredentials().toString();

        if (isValidUser(username, password)) {

            return new UsernamePasswordAuthenticationToken(username, password); // sent security
        } else {
            throw new AuthenticationException("Invalid credentials") {
            };
        }
    }

    private boolean isValidUser(String username, String password) {

        UserEntity user = UsersRepository.findByUsername(username).get(); // find use details from DB

        Boolean validateUser = user.getUsername().equals(username); // check usename
        Boolean validatePass = PasswordEncoder.matches(password, user.getPassword()); // check password

        return validateUser && validatePass;
    }
}
