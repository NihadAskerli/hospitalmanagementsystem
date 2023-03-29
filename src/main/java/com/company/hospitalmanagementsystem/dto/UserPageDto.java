package com.company.hospitalmanagementsystem.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserPageDto {
    private String name;
    private String surname;
    private String doctorName;
    private String doctorSurname;
    private String pastTreatment;
    private LocalDate localDate;
}
