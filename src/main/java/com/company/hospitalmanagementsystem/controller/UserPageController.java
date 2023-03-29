package com.company.hospitalmanagementsystem.controller;

import com.company.hospitalmanagementsystem.dto.UserPageDto;
import com.company.hospitalmanagementsystem.models.Doctor;
import com.company.hospitalmanagementsystem.models.Examination;
import com.company.hospitalmanagementsystem.services.inter.DoctorService;
import com.company.hospitalmanagementsystem.services.inter.ExaminationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userPage")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class UserPageController {

    private final ExaminationService examinationService;
    private final DoctorService doctorService;

    @GetMapping("/user")
    public ResponseEntity<UserPageDto> getUser(@RequestParam String name, @RequestParam String surname) {
        Examination examination = examinationService.getUserByNameAndSurname(name, surname);
        Doctor doctor = doctorService.getByFinCode(examination.getDoctorFinCode());

        UserPageDto userPageDto=new UserPageDto();
        userPageDto.setName(examination.getName());
        userPageDto.setSurname(examination.getSurname());
        userPageDto.setDoctorName(doctor.getName());
        userPageDto.setDoctorSurname(doctor.getSurname());
        userPageDto.setLocalDate(examination.getLocalDate());
        userPageDto.setPastTreatment(examination.getPastTreatment());

        return ResponseEntity.ok(userPageDto);
    }
}
