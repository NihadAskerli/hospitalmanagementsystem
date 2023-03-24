package com.company.hospitalmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExaminationDto {
    private String doctorFinCode;
    private String name;
    private String surname;
    private String pastTreatment;
    private String localDate;
    private String time;
    private String customFinCode;

}

