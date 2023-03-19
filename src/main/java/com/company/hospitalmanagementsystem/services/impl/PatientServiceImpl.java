package com.company.hospitalmanagementsystem.services.impl;

import com.company.hospitalmanagementsystem.models.Patient;
import com.company.hospitalmanagementsystem.repo.PatientRepository;
import com.company.hospitalmanagementsystem.services.inter.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {
    private final PatientRepository patientRepository;

    @Override
    public List<Patient> getAllPatient() {
        return patientRepository.findAll();
    }

    @Override
    public Patient getById(long id) {
        return patientRepository.findById(id).get();
    }

    @Override
    public Patient save(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public void delete(long id) {
        patientRepository.delete(patientRepository.findById(id).get());
    }

    @Override
    public void update(long id) {

    }
}
