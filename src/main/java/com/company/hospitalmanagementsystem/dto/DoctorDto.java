package com.company.hospitalmanagementsystem.dto;

import com.company.hospitalmanagementsystem.models.Department;
import com.company.hospitalmanagementsystem.models.Hospital;
import com.company.hospitalmanagementsystem.models.Patient;
import com.company.hospitalmanagementsystem.models.Photo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDto {

    private String branch;
    private String cardId;
    private String name;
    private String surname;
    private String finCode;
    private String unWorking;
    private Department department;
    private Photo photo;

//    private Hospital hospital;
//
//    private List<Patient> patient;




}

