package com.company.hospitalmanagementsystem.controller;


import com.company.hospitalmanagementsystem.dto.ExaminationDto;
import com.company.hospitalmanagementsystem.dto.ForAssistantPageDto;
import com.company.hospitalmanagementsystem.models.Examination;
import com.company.hospitalmanagementsystem.services.inter.ExaminationService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/assistantPage")
@RequiredArgsConstructor
public class ForAssistantPageController {

    private final ObjectMapper objectMapper;
    private final ExaminationService examinationService;


    List<ForAssistantPageDto> forAssistantPageDtoList = new ArrayList<>();


    @GetMapping("/search/{doctorFinCode}")
    public ResponseEntity<List<ForAssistantPageDto>> getPatientByDoctor(@PathVariable String doctorFinCode) throws JsonProcessingException {
        List<Examination> examinationList = examinationService.getAllByLocalDate(LocalDate.now());

        for (int i = 0; i < examinationList.size(); i++) {

            ForAssistantPageDto forAssistantPageDto = new ForAssistantPageDto();

            forAssistantPageDto.setName(examinationList.get(i).getName());
            forAssistantPageDto.setSurname(examinationList.get(i).getSurname());
            forAssistantPageDto.setDate(examinationList.get(i).getLocalDate());
            forAssistantPageDto.setTime(examinationList.get(i).getTime());
            forAssistantPageDto.setDoctorFinCode(examinationList.get(i).getDoctorFinCode());
            forAssistantPageDtoList.add(forAssistantPageDto);

        }
        return ResponseEntity.ok(forAssistantPageDtoList);
    }

}
