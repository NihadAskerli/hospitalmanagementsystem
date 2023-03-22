package com.company.hospitalmanagementsystem.services.impl;

import com.company.hospitalmanagementsystem.exception.PaymentException;
import com.company.hospitalmanagementsystem.models.Examination;
import com.company.hospitalmanagementsystem.models.Payment;
import com.company.hospitalmanagementsystem.repo.ExaminationRepository;
import com.company.hospitalmanagementsystem.services.inter.ExaminationService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class ExaminationImplService implements ExaminationService {

    private final ExaminationRepository examinationRepository;
    @Autowired
    PaymentServiceImpl paymentService;

    @Override
    @Transactional
    public void save(Examination examination) {
        examination.setDate(LocalDate.now());
        examinationRepository.save(examination);
    }

}
