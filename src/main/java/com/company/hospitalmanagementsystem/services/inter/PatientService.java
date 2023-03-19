package com.company.hospitalmanagementsystem.services.inter;

import com.company.hospitalmanagementsystem.models.Patient;

import java.util.List;

public interface PatientService {
    List<Patient> getAllPatient();

    Patient getById(long id);

    Patient save(Patient patient);

    void delete(long id);

    void update(long id);
}
