package com.company.hospitalmanagementsystem.repo;

import com.company.hospitalmanagementsystem.models.Examination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ExaminationRepository extends JpaRepository<Examination, Long> {


    List<Examination> getAllByLocalDate(LocalDate localDate);

    List<Examination> getAllByDoctorFinCode(String doctorFinCode);
    List<Examination> getAllByRegisterEmail(String registerEmail);
    void deleteAllByDoctorFinCode(String finCode);

    List<Examination> getByDoctorFinCode( String doctorFinCode);

    List<Examination> getByLocalDateAndDoctorFinCode(LocalDate localDate, String doctorFinCode);

    @Query("select e from Examination e where e.name =?1 and e.surname=?2")
    Examination getUserByNameAndSurname(@Param(value = "name") String name, @Param(value = "surname") String Surname);

}
