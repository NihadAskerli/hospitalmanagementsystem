package com.company.hospitalmanagementsystem.repo;

import com.company.hospitalmanagementsystem.models.Doctor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {
    @Query("select d from Doctor d")
    List<Doctor> getAll();
    Doctor getByFinCode(String finCode);


    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("update Doctor d set d.cardId = ?2 where d.finCode = ?1")
    void updateDoctor(@Param(value = "finCode") String finCode, @Param(value = "cardId") String cardId);

}
