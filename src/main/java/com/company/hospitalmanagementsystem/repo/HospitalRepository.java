package com.company.hospitalmanagementsystem.repo;

import com.company.hospitalmanagementsystem.models.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

public interface HospitalRepository extends JpaRepository<Hospital, Long> {
    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value = "update Hospital hp set hp.budget = :budget where hp.name=:name")
    void updateBudget(@Param("name") String name,@Param("budget") BigDecimal budget );
    Hospital getByName(String name);
}
