package com.company.hospitalmanagementsystem.controller;

import com.company.hospitalmanagementsystem.config.TokenListener;
import com.company.hospitalmanagementsystem.dto.UserPageDto;
import com.company.hospitalmanagementsystem.models.Doctor;
import com.company.hospitalmanagementsystem.models.Examination;
import com.company.hospitalmanagementsystem.services.inter.DoctorService;
import com.company.hospitalmanagementsystem.services.inter.ExaminationService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/userPage")
@RequiredArgsConstructor
public class UserPageController {
    private final TokenListener tokenListener;
    private final ExaminationService examinationService;
    private final DoctorService doctorService;

    @GetMapping("/userExaminations")
    public ResponseEntity<List> getUser(HttpServletRequest httpServletRequest) {
        String registerEmail = tokenListener.getEmailFromToken(httpServletRequest.getHeader("Authorization").substring(7));
        if (registerEmail != null && examinationService.getAllExaminationByRegisterEmail(registerEmail) != null) {
            List<Examination> examinationList = examinationService.getAllExaminationByRegisterEmail(registerEmail);
            List<UserPageDto> userPageDtos = new ArrayList<>();
            for (Examination examination : examinationList
            ) {
                UserPageDto userPageDto = new UserPageDto();
                userPageDto.setName(examination.getName());
                userPageDto.setSurname(examination.getSurname());
                userPageDto.setTime(examination.getTime());
                userPageDto.setLocalDate(examination.getLocalDate());
                Doctor doctor = doctorService.getByFinCode(examination.getDoctorFinCode());
                userPageDto.setDoctorName(doctor.getName());
                userPageDto.setDoctorSurname(doctor.getSurname());
                userPageDtos.add(userPageDto);
            }
            return ResponseEntity.ok(userPageDtos);
        }
            return ResponseEntity.ok(null);

    }
}
