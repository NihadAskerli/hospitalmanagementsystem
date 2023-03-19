package com.company.hospitalmanagementsystem.services.impl;



import com.company.hospitalmanagementsystem.config.JWTIssuer;
import com.company.hospitalmanagementsystem.config.UserPrinciple;
import com.company.hospitalmanagementsystem.models.LoginResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final JWTIssuer jwtIssuer;
    private final AuthenticationManager authenticationManager;
    public LoginResponse loginResponse(String username, String password){
        var authetication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,
                password));
        SecurityContextHolder.getContext().setAuthentication(authetication);
        var principal=(UserPrinciple)authetication.getPrincipal();
        var roles=principal.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList();

        var token=jwtIssuer.issue(principal.getUserId(),principal.getEmail(), roles);
        return LoginResponse.builder()
                .accessToken(token)
                .build();
    }

}
