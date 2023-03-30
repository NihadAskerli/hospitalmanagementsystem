package com.company.hospitalmanagementsystem.controller;


import com.company.hospitalmanagementsystem.config.TokenListener;
import com.company.hospitalmanagementsystem.dto.RoleDto;
import com.company.hospitalmanagementsystem.dto.UserDto;
import com.company.hospitalmanagementsystem.models.LoginRequest;
import com.company.hospitalmanagementsystem.models.LoginResponse;
import com.company.hospitalmanagementsystem.models.Role;
import com.company.hospitalmanagementsystem.models.UserEntity;
import com.company.hospitalmanagementsystem.services.impl.AuthService;
import com.company.hospitalmanagementsystem.services.impl.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final AuthService authService;
private final TokenListener tokenListener;
    private final ObjectMapper objectMapper;

    @PostMapping("/login")
    public ResponseEntity<RoleDto> login(HttpServletRequest httpServletRequest) {
        String token = httpServletRequest.getHeader("Authorization").substring(7);
        RoleDto roleDto = new RoleDto();
        roleDto.setId(1l);
        roleDto.setRoles(tokenListener.extractRoles(token));
        return ResponseEntity.ok(roleDto);
    }


    @PostMapping("/register")
    public LoginResponse register(@RequestBody String register) throws JsonProcessingException {
        LoginRequest loginRequest = objectMapper.readValue(register, LoginRequest.class);
        UserDto userDto = objectMapper.readValue(register, UserDto.class);
        UserEntity userEntity = objectMapper.convertValue(userDto, UserEntity.class);
        List<Role> roleList=new ArrayList<>();
        roleList.add(Role.ROLE_USER);
        userEntity.setRole(roleList);
        userService.saveUser(userEntity);
        return authService.loginResponse(loginRequest.getEmail(), loginRequest.getPassword());
    }
}