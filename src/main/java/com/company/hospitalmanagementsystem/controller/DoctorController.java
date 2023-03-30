package com.company.hospitalmanagementsystem.controller;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.company.hospitalmanagementsystem.config.JWTAuthenticationFilter;
import com.company.hospitalmanagementsystem.config.JWTToPrincipalConverter;
import com.company.hospitalmanagementsystem.config.UserPrinciple;
import com.company.hospitalmanagementsystem.dto.DoctorDto;
import com.company.hospitalmanagementsystem.models.Doctor;
import com.company.hospitalmanagementsystem.services.impl.DoctorServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/doctor")
@RequiredArgsConstructor
public class DoctorController {

    private final DoctorServiceImpl doctorService;
    private final ObjectMapper objectMapper;


    @GetMapping("/all")
    public ResponseEntity<List> getAll() {
        return ResponseEntity.ok(doctorService.getAllDoctor());
    }

    @GetMapping("/search/{finCode}")
    public ResponseEntity<DoctorDto> getByFinCode(@PathVariable String finCode) {
        DoctorDto doctor = objectMapper.convertValue(doctorService.getByFinCode(finCode), DoctorDto.class);
        return ResponseEntity.ok(doctor);
    }

    @PostMapping("/save")
    public ResponseEntity<DoctorDto> save(@RequestBody String doctor) throws JsonProcessingException {
        DoctorDto doctorDto = objectMapper.readValue(doctor, DoctorDto.class);
        return ResponseEntity.ok(objectMapper.convertValue(doctorService.save(objectMapper
                .convertValue(doctorDto, Doctor.class)), DoctorDto.class));

    }

    @DeleteMapping("/delete/{finCode}")
    public void delete(@PathVariable String finCode) {
        doctorService.delete(finCode);
    }


    @PutMapping("/update/{finCode}")
    public void update(@PathVariable String finCode, @RequestBody String doctor) throws JsonProcessingException {

        DoctorDto doctorDto = objectMapper.readValue(doctor, DoctorDto.class);

        doctorService.update(finCode, objectMapper
                .convertValue(doctorDto, Doctor.class));

    }

}
