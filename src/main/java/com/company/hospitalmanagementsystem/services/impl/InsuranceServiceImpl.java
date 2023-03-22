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
    public Insurance getByFinCode(String id) {
        return insuranceRepository.getByFinCode(id);
    }
}
