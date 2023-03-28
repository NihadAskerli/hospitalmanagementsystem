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
    public List<Examination> getAllByLocalDate() {
        return examinationRepository.getAllByLocalDate(LocalDate.now());
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
    public List<Examination> getByDoctorFinCode(String finCode) {

        return examinationRepository.getByDoctorFinCode(finCode);
    }

    @Override
    public List<Examination> getKeepExaminations(LocalDate localDate, String finCdoe) {
        return examinationRepository.getByLocalDateAndDoctorFinCode(localDate, finCdoe);
    }

    @Override
    public Examination getUserByNameAndSurname(String name, String surname) {
        return examinationRepository.getUserByNameAndSurname(name, surname);

    }


}