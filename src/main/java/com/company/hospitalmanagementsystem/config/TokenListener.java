package com.company.hospitalmanagementsystem.config;


import com.company.hospitalmanagementsystem.config.JWTDecoder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class TokenListener{
    private final JWTDecoder jwtDecoder;


    public  String getEmailFromToken(String token) {
        String email =jwtDecoder.decode(token).getClaim("e").asString();
        return email;
    }


}
