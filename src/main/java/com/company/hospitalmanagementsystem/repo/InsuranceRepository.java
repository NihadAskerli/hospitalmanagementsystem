package com.company.hospitalmanagementsystem.repo;

import com.company.hospitalmanagementsystem.models.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InsuranceRepository extends JpaRepository<Insurance,Long> {
    Insurance getByFinCode(String finCode);

}
