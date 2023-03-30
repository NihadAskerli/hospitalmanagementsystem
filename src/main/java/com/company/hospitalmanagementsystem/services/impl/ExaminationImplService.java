package com.company.hospitalmanagementsystem.services.impl;

import com.company.hospitalmanagementsystem.models.Examination;
import com.company.hospitalmanagementsystem.repo.ExaminationRepository;
import com.company.hospitalmanagementsystem.services.inter.ExaminationService;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExaminationImplService implements ExaminationService {

    private final ExaminationRepository examinationRepository;

    @Override
    public void saveExamintaion(Examination examination) {
        examinationRepository.save(examination);

    }

    @Override
    public List<Examination> getAll() {
        return examinationRepository.findAll();
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
        return null;
    }


    @Override
    public List<Examination> getKeepExaminations(LocalDate localDate, String finCdoe) {
        return examinationRepository.getByLocalDateAndDoctorFinCode(localDate, finCdoe);
    }

    @Override
    public List<Examination> getAllExaminationByRegisterEmail(String email) {
        return examinationRepository.getAllByRegisterEmail(email);
    }

    @Override
    public List<Examination> getByLocalDateAndDoctorFinCode(LocalDate localDate, String finCode) {
        return examinationRepository.getByLocalDateAndDoctorFinCode(localDate, finCode);
    }




}