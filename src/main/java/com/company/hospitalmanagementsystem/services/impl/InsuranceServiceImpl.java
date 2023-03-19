package com.company.hospitalmanagementsystem.services.impl;

import com.company.hospitalmanagementsystem.models.Insurance;
import com.company.hospitalmanagementsystem.repo.InsuranceRepository;
import com.company.hospitalmanagementsystem.services.inter.InsuranceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InsuranceServiceImpl implements InsuranceService {
    private final InsuranceRepository insuranceRepository;

    @Override
    public List<Insurance> getAllInsurance() {
        return insuranceRepository.findAll();
    }

    @Override
    public Insurance getById(long id) {
        return insuranceRepository.findById(id).get();
    }

    @Override
    public Insurance save(Insurance insurance) {
        return insuranceRepository.save(insurance);
    }

    @Override
    public void delete(long id) {
        insuranceRepository.delete(insuranceRepository.findById(id).get());
    }

    @Override
    public void update(long id) {

    }
}
