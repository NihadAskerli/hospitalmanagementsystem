package com.company.hospitalmanagementsystem.repo;

import com.company.hospitalmanagementsystem.models.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository extends JpaRepository<Hospital,Long> {
}
