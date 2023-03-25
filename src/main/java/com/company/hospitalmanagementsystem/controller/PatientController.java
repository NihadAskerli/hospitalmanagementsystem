package com.company.hospitalmanagementsystem.controller;

import com.company.hospitalmanagementsystem.dto.AssistantDto;
import com.company.hospitalmanagementsystem.dto.PatientDto;
import com.company.hospitalmanagementsystem.models.Patient;
import com.company.hospitalmanagementsystem.services.impl.PatientServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
@RequiredArgsConstructor
public class PatientController {
    private final ObjectMapper objectMapper;
    @Autowired
    PatientServiceImpl patientService;

    @GetMapping("/all")
    public ResponseEntity<List> getAllAssistant() {
        return ResponseEntity.ok(patientService.getAllPatient());
    }

    @PostMapping
    public ResponseEntity<PatientDto> save(@RequestBody String patient) {
        patientService.save(objectMapper.convertValue(objectMapper.convertValue(patient, PatientDto.class), Patient.class));
        return ResponseEntity.ok(objectMapper.convertValue(patient, PatientDto.class));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        patientService.delete(id);
    }



}

