package com.company.hospitalmanagementsystem.controller;

import com.company.hospitalmanagementsystem.dto.DoctorDto;
import com.company.hospitalmanagementsystem.models.Doctor;
import com.company.hospitalmanagementsystem.services.impl.DoctorServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
@RequiredArgsConstructor
public class DoctorController {
    @Autowired
    public DoctorServiceImpl doctorService;
    private final ObjectMapper objectMapper;


    @GetMapping("/all")
    public ResponseEntity<List> getAll() {
        System.out.println("salam");
        List<Doctor>doctors=doctorService.getAllDoctor();
        return ResponseEntity.ok(doctors);
    }
    @GetMapping("/{finCode}")
    public ResponseEntity<DoctorDto> getByFinCode(@PathVariable String finCode) {
      DoctorDto doctor=objectMapper.convertValue( doctorService.getByFinCode(finCode),DoctorDto.class);
        System.out.println(doctor);
        return ResponseEntity.ok(doctor);
    }
    @GetMapping("/demo")
    public ResponseEntity<String> getDemo() {
        return ResponseEntity.ok("Nihad");
    }

    @PostMapping
    public ResponseEntity<DoctorDto> save(@RequestBody String doctor) {
        doctorService.save(objectMapper.convertValue(objectMapper.convertValue(doctor, DoctorDto.class),
                Doctor.class));
        return ResponseEntity.ok(objectMapper.convertValue(doctor, DoctorDto.class));
    }

//    @GetMapping("/branch")
//    public List<String> getBranch() {
//        List<String> branchList = new ArrayList<>();
//
//        for (Doctor doctor : doctorService.getAllDoctor()) {
//            branchList.add(doctor.getDepartment());
//        }
//        return branchList;
//    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        doctorService.delete(id);
    }


//    @PutMapping("/{finCode}")
//    public ResponseEntity<DoctorDto> update(@PathVariable String finCode, @RequestBody DoctorDto doctorDto) {
//        return ResponseEntity.ok(objectMapper.convertValue(doctorService.update(finCode, objectMapper
//                .convertValue(doctorDto, Doctor.class)), DoctorDto.class));
//
//    }


//    @PutMapping("/{finCode}")
//    public ResponseEntity<DoctorDto> update(@PathVariable String finCode, @RequestBody String doctor) {
//        return ResponseEntity.ok(objectMapper.convertValue(doctorService.update(finCode, objectMapper
//                        .convertValue(objectMapper.convertValue(doctor, DoctorDto.class), Doctor.class)),
//                DoctorDto.class));
//
//    }



}


