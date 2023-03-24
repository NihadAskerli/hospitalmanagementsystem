package com.company.hospitalmanagementsystem.services.inter;

import com.amazonaws.services.budgets.model.Budget;
import com.company.hospitalmanagementsystem.models.Hospital;

import java.math.BigDecimal;
import java.util.List;

public interface HospitalService {
    List<Hospital> getAllHospital();

    Hospital getByName(String name);

    Hospital save(Hospital hospital);

    void delete(long id);

    void updateBudget(String name, BigDecimal budget);
}
