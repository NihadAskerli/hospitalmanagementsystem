package com.company.hospitalmanagementsystem.controller;

import com.company.hospitalmanagementsystem.dto.DoctorDto;
import com.company.hospitalmanagementsystem.models.Doctor;
import com.company.hospitalmanagementsystem.services.impl.DoctorServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
@RequiredArgsConstructor
public class DoctorController {
    @Autowired
    public DoctorServiceImpl doctorService;
    private final ObjectMapper objectMapper;

    @CrossOrigin
    @GetMapping("/all")
    public ResponseEntity<List> getAll() {
        return ResponseEntity.ok(doctorService.getAllDoctor());
    }

    @CrossOrigin
    @GetMapping("/{finCode}")
    public ResponseEntity<DoctorDto> getByFinCode(@PathVariable String finCode) {
        DoctorDto doctor = objectMapper.convertValue(doctorService.getByFinCode(finCode), DoctorDto.class);
        return ResponseEntity.ok(doctor);
    }

    @CrossOrigin
    @PostMapping
    public ResponseEntity<DoctorDto> save(@RequestBody String doctor) {
        doctorService.save(objectMapper.convertValue(objectMapper.convertValue(doctor, DoctorDto.class),
                Doctor.class));
        return ResponseEntity.ok(objectMapper.convertValue(doctor, DoctorDto.class));
    }


    @CrossOrigin
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

//    @CrossOrigin
//    @PutMapping("/{finCode}")
//    public ResponseEntity<DoctorDto> update(@PathVariable String finCode, @RequestBody String doctor) {
//        return ResponseEntity.ok(objectMapper.convertValue(doctorService.update(finCode, objectMapper
//                        .convertValue(objectMapper.convertValue(doctor, DoctorDto.class), Doctor.class)),
//                DoctorDto.class));
//
//    }


}


