package com.company.hospitalmanagementsystem.dto;

import com.company.hospitalmanagementsystem.models.Doctor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDto {
    private String name;
    private String surname;
    private String email;
    private String phone;
    private String address;
    private Doctor doctor;
}
