package com.company.hospitalmanagementsystem.controller;

import com.company.hospitalmanagementsystem.dto.ExaminationDto;
import com.company.hospitalmanagementsystem.models.Examination;
import com.company.hospitalmanagementsystem.services.impl.QueueService;
import com.company.hospitalmanagementsystem.services.impl.WorkTimeServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/examination")
@RequiredArgsConstructor
public class ExaminationController {
    private final ObjectMapper objectMapper;
    public static List<Examination> checkExamination = new ArrayList<>();
    private final QueueService queueService;
    private final WorkTimeServiceImpl workTimeService;

    @PostMapping("/check")
    public ResponseEntity<String> checkTime(@RequestBody String check) throws JsonProcessingException, ParseException {
        ExaminationDto examinationDto = objectMapper.readValue(check, ExaminationDto.class);
        String date = queueService.convertDate(examinationDto.getLocalDate());
        examinationDto.setLocalDate(date);
        Examination examination = objectMapper.convertValue(examinationDto, Examination.class);
        if(workTimeService.getByDoctorFinCodeAndLocalDate(examination.getDoctorFinCode(),examination.getLocalDate().getDayOfWeek().toString()).getWeekOfDay()==null){
            return ResponseEntity.ok("seçdiyiniz həkim bu gün işləmir");
        }else {
            checkExamination.add(examination);

        }
        return ResponseEntity.ok(null);
    }

}
