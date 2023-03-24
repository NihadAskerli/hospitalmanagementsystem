package com.company.hospitalmanagementsystem.repo;

import com.company.hospitalmanagementsystem.models.Examination;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ExaminationRepository extends JpaRepository<Examination,Long> {

    List<Examination> getAllByLocalDate(LocalDate localDate);
    List<Examination> getAllByDoctorFinCode(String doctorFinCode);
    void deleteAllByDoctorFinCode(String finCode);
    Examination getByDoctorFinCode(String finCode);

}
