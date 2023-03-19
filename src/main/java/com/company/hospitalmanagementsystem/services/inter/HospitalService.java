package com.company.hospitalmanagementsystem.services.inter;

import com.company.hospitalmanagementsystem.models.Hospital;

import java.util.List;

public interface HospitalService {
    List<Hospital> getAllHospital();

    Hospital getById(long id);

    Hospital save(Hospital hospital);

    void delete(long id);

    void update(long id);
}
