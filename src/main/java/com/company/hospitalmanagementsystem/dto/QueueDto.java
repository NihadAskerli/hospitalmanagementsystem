package com.company.hospitalmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QueueDto {
    private ExaminationDto examinationDto;
    private String customFinCode;
    private PaymentDto paymentDto;

}
