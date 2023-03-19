package com.company.hospitalmanagementsystem.services.inter;

import com.company.hospitalmanagementsystem.models.Insurance;

import java.util.List;

public interface InsuranceService {
    List<Insurance> getAllInsurance();

    Insurance getById(long id);

    Insurance save(Insurance insurance);

    void delete(long id);

    void update(long id);
}
