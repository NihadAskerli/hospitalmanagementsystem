package com.company.hospitalmanagementsystem.services.impl;

import com.company.hospitalmanagementsystem.models.Doctor;
import com.company.hospitalmanagementsystem.repo.DoctorRepository;
import com.company.hospitalmanagementsystem.services.inter.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;

    @Autowired
    HospitalServiceImpl hospitalService;

    @Override
    public List<Doctor> getAllDoctor() {
        return doctorRepository.getAll();
    }

    @Override
    public Doctor getByFinCode(String finCode) {
        return doctorRepository.getByFinCode(finCode);
    }

    @Override
    public Doctor save(Doctor doctor) {
        return doctorRepository.save(doctor);
    }


    @Override
    public void delete(String finCode) {
        doctorRepository.delete(doctorRepository.getByFinCode(finCode));
    }

    @Override
    public void update(String finCode, Doctor doctor) {
        doctorRepository.updateDoctor(finCode, doctor.getCardId());

    }



}

