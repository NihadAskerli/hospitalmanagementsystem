package com.company.hospitalmanagementsystem.controller;

import com.company.hospitalmanagementsystem.dto.DoctorDto;
import com.company.hospitalmanagementsystem.models.Doctor;
import com.company.hospitalmanagementsystem.services.impl.DoctorServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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


}
