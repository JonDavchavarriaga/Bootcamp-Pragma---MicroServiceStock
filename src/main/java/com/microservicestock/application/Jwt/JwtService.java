package com.microservicestock.application.Jwt;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.function.Function;

@Service

public class JwtService {

    private static final String SECRET_KEY="vNf3xL9wqF2d7hK4jB1pD6rT8cQ9mZxP7gV6yN8uA4wS3nM5oL1vE2bR5hC8kU9";

    public String getToken(UserDetails user) {
        return getToken(new HashMap<>(),user);
    }
    private String getToken(HashMap<String, Object> extraClaims, UserDetails user) {
        return Jwts.builder()
                .setClaims(extraClaims)
                .setSubject(user.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(getKey(), SignatureAlgorithm.HS256)
                .compact();
    }
    private Key getKey(){
        byte[] keyBytes= Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String getUsernamefromToken(String token) {
        return getClaim(token,Claims::getSubject);
    }

    public boolean isValidToken(String token, UserDetails userDetails) {
        final String username= getUsernamefromToken(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));

    }

    private Claims getAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
    public <T> T getClaim(String token,Function<Claims,T> claimsResolver){
        final Claims claims=getAllClaims(token);
        return claimsResolver.apply(claims);
    }
    private Date getExpiration(String token) {
        return  getClaim(token,Claims::getExpiration);
    }
    private boolean isTokenExpired(String token) {
        return getExpiration(token).before(new Date());
    }
}
