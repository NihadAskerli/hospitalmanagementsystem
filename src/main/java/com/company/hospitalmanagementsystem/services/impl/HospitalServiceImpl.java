package com.company.hospitalmanagementsystem.services.impl;

import com.company.hospitalmanagementsystem.models.Hospital;
import com.company.hospitalmanagementsystem.repo.HospitalRepository;
import com.company.hospitalmanagementsystem.services.inter.HospitalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HospitalServiceImpl implements HospitalService {
    private final HospitalRepository hospitalRepository;

    @Override
    public List<Hospital> getAllHospital() {
        return hospitalRepository.findAll();
    }

    @Override
    public Hospital getByName(String name) {
        return hospitalRepository.getByName(name);
    }

    @Override
    public Hospital save(Hospital hospital) {
        return hospitalRepository.save(hospital);
    }

    @Override
    public void delete(long id) {
        hospitalRepository.delete(hospitalRepository.findById(id).get());
    }

    @Override
    public void updateBudget(String name, BigDecimal budget) {
        hospitalRepository.updateBudget(name,budget);
    }


}