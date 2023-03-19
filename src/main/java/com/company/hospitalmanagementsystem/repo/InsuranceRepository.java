package com.company.hospitalmanagementsystem.repo;

import com.company.hospitalmanagementsystem.models.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceRepository extends JpaRepository<Insurance,Long> {
}
