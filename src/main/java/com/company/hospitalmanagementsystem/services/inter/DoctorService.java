package com.company.hospitalmanagementsystem.services.inter;

import com.company.hospitalmanagementsystem.models.Doctor;

import java.util.List;

public interface DoctorService {
    List<Doctor> getAllDoctor();

    Doctor getByFinCode(String finCode);

    Doctor save(Doctor doctor);

    void delete(long id);

    void update(long id);
}
