package com.company.hospitalmanagementsystem.controller;

import com.company.hospitalmanagementsystem.dto.DoctorDto;
import com.company.hospitalmanagementsystem.dto.ExaminationDto;
import com.company.hospitalmanagementsystem.models.Doctor;
import com.company.hospitalmanagementsystem.models.Examination;
import com.company.hospitalmanagementsystem.services.impl.ExaminationImplService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/examination")
@RequiredArgsConstructor
public class ExaminationController {
    private final ExaminationImplService examinationService;
    private final ObjectMapper objectMapper;

//    @PostMapping("/add")
//    public ResponseEntity<ExaminationDto> save( @RequestBody String examination) throws JsonProcessingException {
//        ExaminationDto examinationDto = objectMapper.readValue(examination, ExaminationDto.class);
//        return ResponseEntity.ok(objectMapper.convertValue(examinationService.save(objectMapper
//                .convertValue(examinationDto, Examination.class)), ExaminationDto.class));
//    }

//    @PostMapping
//    public ResponseEntity<ExaminationDto> save(@RequestBody String examination) {
//        return ResponseEntity.ok(objectMapper
//                .convertValue(examinationService
//                        .save(objectMapper.convertValue(objectMapper.convertValue(examination,ExaminationDto.class),
//                                Examination.class)), ExaminationDto.class));
//    }

}
