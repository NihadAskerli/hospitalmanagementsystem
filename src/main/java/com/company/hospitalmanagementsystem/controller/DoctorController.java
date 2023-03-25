package com.company.hospitalmanagementsystem.controller;

import com.company.hospitalmanagementsystem.dto.DoctorDto;
import com.company.hospitalmanagementsystem.dto.ExaminationDto;
import com.company.hospitalmanagementsystem.models.Doctor;

import com.company.hospitalmanagementsystem.models.Examination;
import com.company.hospitalmanagementsystem.services.impl.DoctorServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://hospital.us-east-1.elasticbeanstalk.com")
public class DoctorController {



    private final DoctorServiceImpl doctorService;

    private final ObjectMapper objectMapper;


    @GetMapping("/all")
    public ResponseEntity<List> getAll() {
        return ResponseEntity.ok(doctorService.getAllDoctor());
    }

    @GetMapping("/{finCode}")
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


    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        doctorService.delete(id);
    }


//    @PutMapping("/{finCode}")
//    public ResponseEntity<DoctorDto> update(@PathVariable String finCode, @RequestBody DoctorDto doctorDto) {
//        return ResponseEntity.ok(objectMapper.convertValue(doctorService.update(finCode, objectMapper
//                .convertValue(doctorDto, Doctor.class)), DoctorDto.class));
//
//    }

    @PutMapping("/{finCode}")
    public void update(@PathVariable String finCode, @RequestBody String doctor) {

        doctorService.update(finCode, objectMapper
                .convertValue(objectMapper
                        .convertValue(doctor, DoctorDto.class), Doctor.class));


    }



    }
