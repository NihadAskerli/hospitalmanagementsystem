package com.company.hospitalmanagementsystem.controller;

import com.company.hospitalmanagementsystem.config.UserPrinciple;
import com.company.hospitalmanagementsystem.dto.DoctorDto;
import com.company.hospitalmanagementsystem.models.Doctor;
import com.company.hospitalmanagementsystem.repo.DoctorRepository;
import com.company.hospitalmanagementsystem.services.impl.DoctorServiceImpl;
import com.company.hospitalmanagementsystem.services.inter.DoctorService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
//@RequestMapping("/doctor")
@RequiredArgsConstructor
public class DoctorController {
    @Autowired
    public DoctorServiceImpl doctorService;
    private final ObjectMapper objectMapper;




    @GetMapping("/all")
//    @PreAuthorize("hasRole('ROLE_USER')")
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
    //    @PostMapping
//    public ResponseEntity<DoctorDto> save(@RequestBody DoctorDto doctorDto) {
//        return ResponseEntity.ok(objectMapper.convertValue(doctorService.save(objectMapper
//                        .convertValue(doctorDto, Doctor.class)),
//                DoctorDto.class));
//    }
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

//    @GetMapping("/doctor/filter")
//    public ResponseEntity<Map<String, Object>> getAllTutorials(
//            @RequestParam(required = false) String name,
//            @RequestParam(defaultValue = "0") int page,
//            @RequestParam(defaultValue = "3") int size
//    ) {
//
//        try {
//            List<Doctor> doctors = new ArrayList<Doctor>();
//            Pageable paging = PageRequest.of(page, size);
//
//            Page<Doctor> pageTuts;
//            if (name == null)
//                pageTuts = doctorRepository.findAll(paging);
//            else
//                pageTuts = doctorRepository.(name, paging);
//
//            doctors = pageTuts.getContent();
//
//            Map<String, Object> response = new HashMap<>();
//            response.put("doctors", doctors);
//            response.put("totalItems", pageTuts.getTotalElements());
//
//            return new ResponseEntity<>(response, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

}


