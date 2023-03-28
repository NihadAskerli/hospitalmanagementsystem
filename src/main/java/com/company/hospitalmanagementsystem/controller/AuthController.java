package com.company.hospitalmanagementsystem.controller;


import com.company.hospitalmanagementsystem.dto.UserDto;
import com.company.hospitalmanagementsystem.models.LoginRequest;
import com.company.hospitalmanagementsystem.models.LoginResponse;
import com.company.hospitalmanagementsystem.models.Role;
import com.company.hospitalmanagementsystem.models.UserEntity;
import com.company.hospitalmanagementsystem.services.impl.AuthService;
import com.company.hospitalmanagementsystem.services.impl.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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

    private final ObjectMapper objectMapper;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody @Validated String login) throws JsonProcessingException {
        LoginRequest loginRequest=objectMapper.readValue(login, LoginRequest.class);
        return ResponseEntity.ok(authService.loginResponse(loginRequest.getEmail(), loginRequest.getPassword()));
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody String register) throws JsonProcessingException {
        UserDto userDto = objectMapper.readValue(register, UserDto.class);
         if(userService.findByEmail(userDto.getEmail()).isEmpty()) {
            UserEntity userEntity = objectMapper.convertValue(userDto, UserEntity.class);
            List<Role> roleList = new ArrayList<>();
            roleList.add(Role.ROLE_USER);
            userEntity.setRole(roleList);
            userService.saveUser(userEntity);
            return ResponseEntity.ok("ugurla register olundunuz");
        }else {
            return ResponseEntity.ok("Zehmet olmasa düzgün email daxil edin");
        }
    }
}