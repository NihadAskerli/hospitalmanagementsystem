package com.company.hospitalmanagementsystem.repo;

import com.company.hospitalmanagementsystem.models.Salary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaryRepository extends JpaRepository<Salary,Long> {
}
