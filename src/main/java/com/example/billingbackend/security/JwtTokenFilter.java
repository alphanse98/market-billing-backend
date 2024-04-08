package com.example.billingbackend.security;

import com.example.billingbackend.entity.UserEntity;
import com.example.billingbackend.repository.UsersRepository;
import com.example.billingbackend.security.JwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class JwtTokenFilter extends OncePerRequestFilter {

    // OncePerRequestFilter run once

    private JwtUtil jwtUtil;
    private UsersRepository usersRepository;


    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        String authorizationHeader = request.getHeader("Authorization");                //get jwt token from request payload

//        System.out.println("authorizationHeader token " + authorizationHeader);

        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer")) {    //check token or Bearer
            filterChain.doFilter(request, response);
//            "Bearer "+token
            return;
        }

        String token = authorizationHeader.split(" ")[1];     // split the token like remove Bearer

        if (!jwtUtil.validate(token)) {                             //if it is not valid return filterChain
            filterChain.doFilter(request, response);
            return;
        }

        String username = jwtUtil.getUsername(token);  // get username from token

//        System.out.println("username from token >> " + username);

        UserEntity user = usersRepository.findByUsername(username).get(); // find username from DB

        System.out.println("username from Db  >> " + user);


        // set authorities
//        Set<GrantedAuthority> authorities = user.getRoles().stream()
//                .map(role -> new SimpleGrantedAuthority(role.getName()))
//                .collect(Collectors.toSet());



//        replace UsernamePasswordAuthenticationToken (extra add n number authorities)
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(username, user.getPassword(),new ArrayList<GrantedAuthority>());
        usernamePasswordAuthenticationToken.setDetails(
                new WebAuthenticationDetailsSource().buildDetails(request) // sent request params
        );

        // sent to spring Context
        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

        filterChain.doFilter(request, response); // move next filter

    }
}
