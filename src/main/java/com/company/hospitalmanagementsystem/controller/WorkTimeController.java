package com.company.hospitalmanagementsystem.controller;


import com.company.hospitalmanagementsystem.dto.ExaminationDto;
import com.company.hospitalmanagementsystem.dto.WorkTimeDto;
import com.company.hospitalmanagementsystem.models.Examination;
import com.company.hospitalmanagementsystem.services.impl.QueueService;
import com.company.hospitalmanagementsystem.services.impl.WorkTimeServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/workTime")
@RequiredArgsConstructor
public class WorkTimeController {

    private final ObjectMapper objectMapper;
    private final WorkTimeServiceImpl unWorkTimeService;
    private final QueueService queueService;
    @GetMapping("/correctTime")
    public ResponseEntity<WorkTimeDto> sendCorrectTime(@RequestBody String examintaion) throws JsonProcessingException, ParseException {
        ExaminationDto examinationDto=objectMapper.readValue(examintaion, ExaminationDto.class);
        examinationDto.setLocalDate(queueService.convertDate(examinationDto.getLocalDate()));
        Examination examination=objectMapper.convertValue(examinationDto, Examination.class);
        List<String> times = unWorkTimeService.getByDoctorFinCodeAndLocalDate(examination.getDoctorFinCode(), examination.getLocalDate().getDayOfWeek().toString()).getTimes();
        times.removeAll(unWorkTimeService.keepTimes(examination));
        WorkTimeDto wokrTimeDto=new WorkTimeDto();
        wokrTimeDto.setId(1l);
        wokrTimeDto.setTimes(times);
        return ResponseEntity.ok(wokrTimeDto);
    }

}
