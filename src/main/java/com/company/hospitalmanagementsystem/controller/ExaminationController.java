package com.company.hospitalmanagementsystem.controller;

import com.company.hospitalmanagementsystem.dto.ExaminationDto;
import com.company.hospitalmanagementsystem.models.Examination;
import com.company.hospitalmanagementsystem.services.impl.ExaminationImplService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/examination")
@RequiredArgsConstructor
public class ExaminationController {
    private final ExaminationImplService examinationService;
    private final ObjectMapper objectMapper;
    @PostMapping("/add")
    public void addExamination( @RequestBody ExaminationDto examinationDto){
        Examination examination=objectMapper.convertValue(examinationDto, Examination.class);
        System.out.println(examination);
         examinationService.save(examination);
    }
}
