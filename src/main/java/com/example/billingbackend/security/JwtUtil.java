package com.example.billingbackend.security;

import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

@Service
public class JwtUtil {
    public static final int expireInMs = 3000 * 1000; // exprire time  in ms
    public static  final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);  // key for jwt token


//    generateJwt
    public  String  generateJwt(String username){
        String jwtToken = Jwts.builder()
                .setSubject(username)

                .setIssuer("alphanse.com")
                .setIssuedAt(new Date(System.currentTimeMillis())) //set created time
                .setExpiration(new Date(System.currentTimeMillis() + expireInMs)) // set exprite time
                .signWith(key)
                .compact();
//        System.out.println(" jwtToken>>>>  " + jwtToken);
        return jwtToken;
    }


//    check the user jwt token valid or not
    public boolean validate(String token) {
        if (getUsername(token) != null && isExpired(token)) { // check token isExpired and username
            return true;
        }
        return false;
    }

    public String getUsername(String token) {
        return getClaims(token).getSubject();
    }

    public boolean isExpired(String token) {
        return getClaims(token).
                getExpiration().after(new Date(System.currentTimeMillis()));
    }

    private Claims getClaims(String token) {
        return Jwts.parser().setSigningKey(key).build().parseClaimsJws(token).getBody();
    }
}
