package com.company.hospitalmanagementsystem.repo;

import com.company.hospitalmanagementsystem.models.Doctor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {
    @Query("select d from Doctor d")
    List<Doctor> getAll();
    Doctor getByFinCode(String finCode);
}
