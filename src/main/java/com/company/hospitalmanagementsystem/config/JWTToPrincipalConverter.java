package com.company.hospitalmanagementsystem.config;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.company.hospitalmanagementsystem.controller.DoctorController;
import com.company.hospitalmanagementsystem.models.Examination;
import com.company.hospitalmanagementsystem.services.impl.DoctorServiceImpl;
import com.company.hospitalmanagementsystem.services.impl.ExaminationImplService;
import com.company.hospitalmanagementsystem.services.impl.QueueService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class JWTToPrincipalConverter {
    private final ExaminationImplService examinationImplService;
    public UserPrinciple convert(DecodedJWT jwt){

        return UserPrinciple.builder()
                .userId(Long.valueOf(jwt.getSubject()))
                .email(jwt.getClaim("e").asString())
                .authorities(extractAuthoritiesFromClaim(jwt))
                .build();
    }
    public List<SimpleGrantedAuthority> extractAuthoritiesFromClaim(DecodedJWT jwt){
        var claim=jwt.getClaim("a");
        if(claim.isNull()|| claim.isMissing()) return List.of();
        return claim.asList(SimpleGrantedAuthority.class);
    }
}
