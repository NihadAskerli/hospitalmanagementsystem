package com.company.hospitalmanagementsystem.controller;

import com.company.hospitalmanagementsystem.dto.ExaminationDto;
import com.company.hospitalmanagementsystem.dto.UnWokrTimeDto;
import com.company.hospitalmanagementsystem.models.Examination;
import com.company.hospitalmanagementsystem.models.UnWorkTime;
import com.company.hospitalmanagementsystem.services.impl.ExaminationImplService;
import com.company.hospitalmanagementsystem.services.impl.UnWorkTimeServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/unworktime")
@RequiredArgsConstructor
public class UnWorkTimeController {
    private final ObjectMapper objectMapper;
    private final UnWorkTimeServiceImpl unWorkTimeService;
    private final ExaminationController examinationController;
    @CrossOrigin
    @GetMapping("/correcttime")
    public ResponseEntity<UnWokrTimeDto> sendCorrectTime() {
        Examination examination = examinationController.checkExamination.get(0);
        List<String> times = unWorkTimeService.getByDoctorFinCodeAndLocalDate(examination.getDoctorFinCode(), examination.getLocalDate().getDayOfWeek().toString()).getTimes();
        times.removeAll(unWorkTimeService.keepTimes(examination));
        UnWokrTimeDto unWokrTimeDto=new UnWokrTimeDto();
        unWokrTimeDto.setId(1l);
        unWokrTimeDto.setTimes(times);
        return ResponseEntity.ok(unWokrTimeDto);
    }

}
