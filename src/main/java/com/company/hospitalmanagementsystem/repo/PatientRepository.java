package com.company.hospitalmanagementsystem.repo;

import com.company.hospitalmanagementsystem.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {
}
