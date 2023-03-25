package com.company.hospitalmanagementsystem.controller;

import com.company.hospitalmanagementsystem.dto.ExaminationDto;
import com.company.hospitalmanagementsystem.dto.QueueDto;
import com.company.hospitalmanagementsystem.models.Examination;
import com.company.hospitalmanagementsystem.models.Payment;
import com.company.hospitalmanagementsystem.services.impl.ExaminationImplService;
import com.company.hospitalmanagementsystem.services.impl.InsuranceServiceImpl;
import com.company.hospitalmanagementsystem.services.impl.PaymentServiceImpl;
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
@CrossOrigin(origins = "http://hospitalmanagementsystem.us-east-1.elasticbeanstalk.com")
public class QueueController {

    private final ObjectMapper objectMapper;

    private final QueueService queueService;
    private final ExaminationImplService examinationImplService;
    private  final PaymentServiceImpl paymentService;

    private final InsuranceServiceImpl insuranceService;

    @PostMapping("/add")
    public ResponseEntity<String> queue(@RequestBody String queue) throws ParseException, JsonProcessingException {
        QueueDto queueDto = queueService.convertQueueDto(queue);
        ExaminationDto examinationDto = queueDto.getExaminationDto();
        examinationDto.setLocalDate(queueService.convertDate(examinationDto.getLocalDate()));
        Examination examination = objectMapper.convertValue(examinationDto, Examination.class);
        Payment payment = objectMapper.convertValue(queueDto.getPaymentDto(), Payment.class);
        payment.setDate(LocalDate.now());
        if(examination.getLocalDate().compareTo(LocalDate.now())<0){
            return ResponseEntity.ok("düzgün tarix daxil edin");
        }
        else if (examination.getCustomFinCode() != null && insuranceService.getByFinCode(examination.getCustomFinCode()) == null ) {
            return ResponseEntity.ok("Sizin sıgortanız yoxdur");
        }else if(queueDto.getExaminationDto().getCustomFinCode() == null && payment.getPay()==null ) {

            return ResponseEntity.ok("Ödenişi ödeyin zəhmet olmasa");

        }  else if (examination.getCustomFinCode() != null && insuranceService.getByFinCode(examination.getCustomFinCode()) != null ) {
            examinationImplService.saveExamintaion(examination);
            paymentService.save(new Payment(null,null,null,examination.getCustomFinCode(),null));
            return ResponseEntity.ok("Növbəniz uöurla qeydə alındı");
        }

        return ResponseEntity.ok(queueService.queueSave(examination, payment));
    }

}