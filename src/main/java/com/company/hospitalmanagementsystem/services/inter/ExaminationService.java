package com.company.hospitalmanagementsystem.services.inter;

import com.company.hospitalmanagementsystem.models.Examination;

import java.time.LocalDate;
import java.util.List;

public interface ExaminationService {

    void saveExamintaion(Examination examintaion);
    List<Examination> getAllByLocalDate(LocalDate localDate);
    List<Examination> getAllByFinCode(String finCode);
    void deleteAllByFinCode(String finCode);
    Examination getByDoctorFinCode(String finCode);
}

