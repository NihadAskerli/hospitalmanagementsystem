package com.company.hospitalmanagementsystem.services.impl;

import com.company.hospitalmanagementsystem.exception.PaymentException;
import com.company.hospitalmanagementsystem.models.Examination;
import com.company.hospitalmanagementsystem.models.Payment;
import com.company.hospitalmanagementsystem.repo.ExaminationRepository;
import com.company.hospitalmanagementsystem.services.inter.ExaminationService;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExaminationImplService implements ExaminationService {

    private final ExaminationRepository examinationRepository;
    private final EntityManager entityManager;

    @Override
    public void saveExamintaion(Examination examination) {
        examinationRepository.save(examination);

    }

    @Override
    public List<Examination> getAllByLocalDate(LocalDate localDate) {
        return examinationRepository.getAllByLocalDate(localDate);
    }

    @Override
    public List<Examination> getAllByFinCode(String finCode) {
        return examinationRepository.getAllByDoctorFinCode(finCode);
    }

    @Override
    @Transactional
    public void deleteAllByFinCode(String finCode) {
        examinationRepository.deleteAllByDoctorFinCode(finCode);
    }

    @Override
    public Examination getByDoctorFinCode(String finCode) {
        return examinationRepository.getByDoctorFinCode(finCode);
    }

}