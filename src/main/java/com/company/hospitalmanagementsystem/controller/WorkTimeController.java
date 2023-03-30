package com.company.hospitalmanagementsystem.controller;


import com.company.hospitalmanagementsystem.dto.ExaminationDto;
import com.company.hospitalmanagementsystem.dto.WorkTimeDto;
import com.company.hospitalmanagementsystem.models.Examination;
import com.company.hospitalmanagementsystem.services.impl.QueueService;
import com.company.hospitalmanagementsystem.services.impl.WorkTimeServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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


    @GetMapping("/correctTime/{finCode}/{month}/{day}/{year}")
    public ResponseEntity<WorkTimeDto> sendCorrectTime(@PathVariable String finCode, @PathVariable String month, @PathVariable String day, @PathVariable String year) throws ParseException {

        String date = month + "/" + day + "/" + year;
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
