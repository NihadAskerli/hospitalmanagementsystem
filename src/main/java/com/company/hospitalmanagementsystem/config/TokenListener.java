package com.company.hospitalmanagementsystem.config;


import com.auth0.jwt.interfaces.DecodedJWT;
import com.company.hospitalmanagementsystem.config.JWTDecoder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;


@Component
@RequiredArgsConstructor
public class TokenListener{
    private final JWTDecoder jwtDecoder;


    public  String getEmailFromToken(String token) {
        String email =jwtDecoder.decode(token).getClaim("e").asString();
        return email;
    }
    public <T> T extractClaim(String token, Function<DecodedJWT, T> claimsResolver) {
        DecodedJWT decodedJWT = jwtDecoder.decode(token);
        return claimsResolver.apply(decodedJWT);
    }
    public List<String> extractRoles(String token) {
        return extractClaim(token, jwt -> jwt.getClaim("a").asList(String.class));
    }

}
