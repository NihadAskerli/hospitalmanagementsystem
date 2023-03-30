package com.company.hospitalmanagementsystem.controller;

import com.amazonaws.services.dynamodbv2.xspec.L;
import com.company.hospitalmanagementsystem.dto.DoctorDto;
import com.company.hospitalmanagementsystem.dto.ExaminationDto;
import com.company.hospitalmanagementsystem.dto.WorkTimeDto;
import com.company.hospitalmanagementsystem.models.Examination;
import com.company.hospitalmanagementsystem.models.WorkTime;
import com.company.hospitalmanagementsystem.services.impl.ExaminationImplService;
import com.company.hospitalmanagementsystem.services.impl.QueueService;
import com.company.hospitalmanagementsystem.services.impl.WorkTimeServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/workTime")
@RequiredArgsConstructor
public class WorkTimeController {
    private final ObjectMapper objectMapper;
    private final WorkTimeServiceImpl unWorkTimeService;
    private final QueueService queueService;

    @GetMapping("/correctTime/{finCode}/{ay}/{gun}/{il}")
    public ResponseEntity<WorkTimeDto> sendCorrectTime(@PathVariable String finCode, @PathVariable String ay, @PathVariable String gun, @PathVariable String il) throws ParseException {

        String date = ay + "/" + gun + "/" + il;

        System.out.println(date);
        ExaminationDto examinationDto = new ExaminationDto();
        examinationDto.setLocalDate(queueService.convertDate(date));
        examinationDto.setDoctorFinCode(finCode);

        Examination examination = objectMapper.convertValue(examinationDto, Examination.class);

        List<String> times = unWorkTimeService.getByDoctorFinCodeAndLocalDate(examination.getDoctorFinCode(), examination.getLocalDate().getDayOfWeek().toString()).getTimes();

        times.removeAll(unWorkTimeService.keepTimes(examination));
        WorkTimeDto unWokrTimeDto = new WorkTimeDto();
        unWokrTimeDto.setId(1l);
        unWokrTimeDto.setTimes(times);
        return ResponseEntity.ok(unWokrTimeDto);
    }

}
