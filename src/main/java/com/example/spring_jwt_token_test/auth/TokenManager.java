package com.example.spring_jwt_token_test.auth;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
//import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;


@Service
public class TokenManager {

    private static final int validateTime=5*60*1000;
    private static final String SECRET_KEY="mySecretKey";

//    public String generateToken(String username) {
//        Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
//        return  Jwts.builder()
//                .setSubject(username)
//                .signWith(SignatureAlgorithm.HS256,SECRET_KEY)
//                .setIssuedAt(new Date (System.currentTimeMillis()))
//                .setExpiration(new Date(System.currentTimeMillis()+validateTime))
//                .compact();
//    }
//
//    public boolean tokenValidate(String token) {
//
//
//    }
//
//    public String getUserFromToken(String token) {
//
//
//
//    }


}
