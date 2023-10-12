package com.example.bookStore.utilities.auth;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Service
public class TokenManager {
    private static final String secretKey = "gabrelBookStore";
    private static final int validity = 5*60*1000;
    public String generateToken(String email){
       return  Jwts.builder()
                .setSubject(email)
                .setIssuer("gabriel@gmail.com")
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+validity))
                .signWith(SignatureAlgorithm.ES256,secretKey)
                .compact();
    }
    public boolean tokenValidate(String token){
        if (getUsernameToken(token) != null && isExpired(token)){
            return true;
        }
        return false;
    }
    public String getUsernameToken(String token){
      Claims claims =  Jwts.parser().setSigningKey(secretKey).parseClaimsJwt(token).getBody();
      return claims.getSubject();
    }

    public boolean isExpired(String token){
        Claims claims =  Jwts.parser().setSigningKey(secretKey).parseClaimsJwt(token).getBody();
        return claims.getExpiration().before(new Date(System.currentTimeMillis()));
    }
}
