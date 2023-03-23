package com.company.hospitalmanagementsystem.controller;

import com.company.hospitalmanagementsystem.dto.ExaminationDto;
import com.company.hospitalmanagementsystem.dto.QueueDto;
import com.company.hospitalmanagementsystem.models.Examination;
import com.company.hospitalmanagementsystem.models.Payment;
import com.company.hospitalmanagementsystem.services.impl.InsuranceServiceImpl;
import com.company.hospitalmanagementsystem.services.impl.QueueService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@RestController
@RequestMapping("/queue")
@RequiredArgsConstructor
public class QueueController {

    private final ObjectMapper objectMapper;
    @Autowired
    QueueService queueService;
    @Autowired
    InsuranceServiceImpl insuranceService;

    @CrossOrigin
    @PostMapping("/add")
    public ResponseEntity<String> queue(@RequestBody String queue) throws ParseException, JsonProcessingException {
        QueueDto queueDto = queueService.convertQueueDto(queue);
        ExaminationDto examinationDto = queueDto.getExaminationDto();
        examinationDto.setLocalDate(queueService.convertDate(examinationDto.getLocalDate()));
        Examination examination = objectMapper.convertValue(examinationDto, Examination.class);
        if(examination.getLocalDate().compareTo(LocalDate.now())<0){
            return ResponseEntity.ok("düzgün tarix daxil edin");
        }
        Payment payment = objectMapper.convertValue(queueDto.getPaymentDto(), Payment.class);
        payment.setDate(LocalDate.now());
        if (queueDto.getExaminationDto().getCustomFinCode() != null && insuranceService.getByFinCode(queueDto.getExaminationDto().getCustomFinCode()) == null ) {

                return ResponseEntity.ok("Sizin sıgortanız yoxdur");
        }else if(queueDto.getExaminationDto().getCustomFinCode() == null && payment.getPay()==null ) {

                return ResponseEntity.ok("Ödenişi ödeyin zəhmet olmasa");

        }

        return ResponseEntity.ok(queueService.queueSave(examination, payment));
    }



}
