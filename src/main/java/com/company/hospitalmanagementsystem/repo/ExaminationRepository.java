package com.company.hospitalmanagementsystem.repo;

import com.company.hospitalmanagementsystem.models.Examination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

public interface ExaminationRepository extends JpaRepository<Examination, Long> {

    List<Examination> getAllByLocalDate(LocalDate localDate);

    List<Examination> getAllByDoctorFinCode(String doctorFinCode);

    void deleteAllByDoctorFinCode(String finCode);


    List<Examination> getByDoctorFinCode( String doctorFinCode);

    List<Examination> getByLocalDateAndDoctorFinCode(LocalDate localDate, String doctorFinCode);

}
