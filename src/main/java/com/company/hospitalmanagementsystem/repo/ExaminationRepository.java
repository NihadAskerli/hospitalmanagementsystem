package com.company.hospitalmanagementsystem.repo;

import com.company.hospitalmanagementsystem.models.Examination;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExaminationRepository extends JpaRepository<Examination,Long> {
}
