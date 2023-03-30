package com.company.hospitalmanagementsystem.controller;


import com.company.hospitalmanagementsystem.dto.ForAssistantPageDto;
import com.company.hospitalmanagementsystem.models.Doctor;
import com.company.hospitalmanagementsystem.models.Examination;
import com.company.hospitalmanagementsystem.services.inter.DoctorService;
import com.company.hospitalmanagementsystem.services.inter.ExaminationService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/assistantPage")
@RequiredArgsConstructor
public class ForAssistantPageController {

    private final ObjectMapper objectMapper;
    private final ExaminationService examinationService;
    private final DoctorService doctorService;
    List<ForAssistantPageDto> forAssistantPageDtoList = new ArrayList<>();


    @GetMapping("/search")
    public ResponseEntity<List<ForAssistantPageDto>> getPatientByDoctor() throws JsonProcessingException {

        List<Examination> examinationList = examinationService.getAllByLocalDate();

        for (Examination examination : examinationList) {

            Doctor doctor = doctorService.getByFinCode(examination.getDoctorFinCode());
            ForAssistantPageDto forAssistantPageDto = new ForAssistantPageDto();

            forAssistantPageDto.setName(examination.getName());
            forAssistantPageDto.setSurname(examination.getSurname());
            forAssistantPageDto.setPastTreatment(examination.getPastTreatment());
            forAssistantPageDto.setLocalDate(examination.getLocalDate());
            forAssistantPageDto.setTime(examination.getTime());
            forAssistantPageDto.setDoctorName(doctor.getName());
            forAssistantPageDto.setDoctorSurname(doctor.getSurname());
            forAssistantPageDto.setDoctorFinCode(doctor.getFinCode());

            forAssistantPageDtoList.add(forAssistantPageDto);
        }
        return ResponseEntity.ok(forAssistantPageDtoList);
    }

}
