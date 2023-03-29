package com.company.hospitalmanagementsystem.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDto {

    private String cardId;
    private String cardCode;
    private String endTime;
    private BigDecimal pay;
    private LocalDate date;


}