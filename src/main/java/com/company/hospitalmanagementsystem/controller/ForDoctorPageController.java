package com.company.hospitalmanagementsystem.controller;


import com.company.hospitalmanagementsystem.dto.AssistantDto;
import com.company.hospitalmanagementsystem.dto.DoctorDto;
import com.company.hospitalmanagementsystem.models.Assistant;
import com.company.hospitalmanagementsystem.models.Doctor;
import com.company.hospitalmanagementsystem.services.inter.AssistantService;
import com.company.hospitalmanagementsystem.services.inter.DoctorService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctorPage")
@RequiredArgsConstructor
public class ForDoctorPageController {

    private final ObjectMapper objectMapper;
    private final DoctorService doctorService;
    private final AssistantService assistantService;


    @GetMapping("/all/doctor")
    public ResponseEntity<List> getAllDoctorAndAssistant() {

        List<Doctor> doctorList = doctorService.getAllDoctor();

        return ResponseEntity.ok(doctorList);

    }

    @GetMapping("/all/assistant")
    public ResponseEntity<List> getAllAssistant(HttpServletRequest httpServletRequest) {
        String token=httpServletRequest.getHeader("Authorization");
        System.out.println(token);

        List<Assistant> assistants = assistantService.getAllAssistant();

        return ResponseEntity.ok(assistants);

    }

    @PostMapping("/addDoctor")
    public ResponseEntity<DoctorDto> addDoctor(@RequestBody String doctor) throws JsonProcessingException {
        DoctorDto doctorDto = objectMapper.readValue(doctor, DoctorDto.class);
        return ResponseEntity.ok(objectMapper.convertValue(doctorService.save(objectMapper
                .convertValue(doctorDto, Doctor.class)), DoctorDto.class));

    }

    @PutMapping("/updateDoctor/{finCode}")
    public void updateDoctor(@PathVariable String finCode, @RequestBody String doctor) throws JsonProcessingException {
        DoctorDto doctorDto = objectMapper.readValue(doctor, DoctorDto.class);
        doctorService.update(finCode, objectMapper.convertValue(doctorDto, Doctor.class));
    }


    @DeleteMapping("/deleteDoctor/{finCode}")
    public void deleteDoctor(@PathVariable String finCode) {
        doctorService.delete(finCode);
    }

    @PostMapping("/addAssistant")
    public ResponseEntity<AssistantDto> addAssistant(@RequestBody String assistant) throws JsonProcessingException {
        AssistantDto assistantDto = objectMapper.readValue(assistant, AssistantDto.class);
        return ResponseEntity.ok(objectMapper.convertValue(assistantService.save(objectMapper
                .convertValue(assistantDto, Assistant.class)), AssistantDto.class));
    }

    @PutMapping("/updateAssistant/{finCode}")
    public void updateAssistant(@PathVariable String finCode, @RequestBody String assistant) throws JsonProcessingException {
        AssistantDto assistantDto = objectMapper.readValue(assistant, AssistantDto.class);
        assistantService.update(finCode, objectMapper.convertValue(assistantDto, Assistant.class));
    }


    @DeleteMapping("/deleteAssistant/{finCode}")
    public void deleteAssistant(@PathVariable String finCode) {
        assistantService.delete(finCode);
    }
}
