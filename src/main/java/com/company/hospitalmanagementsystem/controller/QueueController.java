package com.company.hospitalmanagementsystem.controller;

import com.company.hospitalmanagementsystem.dto.QueueDto;
import com.company.hospitalmanagementsystem.models.Examination;
import com.company.hospitalmanagementsystem.models.Payment;
import com.company.hospitalmanagementsystem.services.impl.InsuranceServiceImpl;
import com.company.hospitalmanagementsystem.services.impl.QueueService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

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
    public String queue(@RequestBody String queue){
        QueueDto queueDto=objectMapper.convertValue(queue,QueueDto.class);
        if(queueDto.getCustomFinCode()!=null){
            if(insuranceService.getByFinCode(queueDto.getCustomFinCode())==null){
                return "Sizin portalda sigortaniz yoxdur";
            }
        }
            Examination examination = objectMapper.convertValue(queueDto.getExaminationDto(), Examination.class);
            examination.setDate(LocalDate.now());
            Payment payment = objectMapper.convertValue(queueDto.getPaymentDto(), Payment.class);
            payment.setDate(LocalDate.now());
            return  queueService.queueSave(examination,payment);

    }
}
