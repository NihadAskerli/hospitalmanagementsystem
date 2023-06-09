package com.company.hospitalmanagementsystem.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ForAssistantPageDto {
    private String name;
    private String surname;
    private String doctorFinCode;
    private LocalDate localDate;
    private String pastTreatment;
    private String time;
    private String doctorName;
    private String doctorSurname;

}
