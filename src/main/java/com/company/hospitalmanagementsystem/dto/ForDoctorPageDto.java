package com.company.hospitalmanagementsystem.dto;


import com.company.hospitalmanagementsystem.models.Assistant;
import com.company.hospitalmanagementsystem.models.Doctor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ForDoctorPageDto {

//    private String doctorName;
//    private String doctorSurname;
//    private String cardId;
//    private String doctorFincode;
//    private String assistantName;
//    private String assistantSurname;
//    private String assistantFinCode;

    List<Doctor> doctorList;
    List<Assistant> assistantList;

}
