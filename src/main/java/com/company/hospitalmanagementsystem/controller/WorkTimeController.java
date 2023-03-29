package com.company.hospitalmanagementsystem.controller;

import com.company.hospitalmanagementsystem.dto.WorkTimeDto;
import com.company.hospitalmanagementsystem.models.Examination;
import com.company.hospitalmanagementsystem.services.impl.WorkTimeServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/workTime")
@RequiredArgsConstructor
public class WorkTimeController {
    private final ObjectMapper objectMapper;
    private final WorkTimeServiceImpl unWorkTimeService;
    private final ExaminationController examinationController;

    @GetMapping("/correctTime")
    public ResponseEntity<WorkTimeDto> sendCorrectTime() {
        Examination examination = ExaminationController.checkExamination.get(0);
        List<String> times = unWorkTimeService.getByDoctorFinCodeAndLocalDate(examination.getDoctorFinCode(), examination.getLocalDate().getDayOfWeek().toString()).getTimes();
        times.removeAll(unWorkTimeService.keepTimes(examination));
        WorkTimeDto unWokrTimeDto=new WorkTimeDto();
        unWokrTimeDto.setId(1l);
        unWokrTimeDto.setTimes(times);
        examinationController.checkExamination.remove(examinationController.checkExamination.get(0));
        return ResponseEntity.ok(unWokrTimeDto);
    }

}
