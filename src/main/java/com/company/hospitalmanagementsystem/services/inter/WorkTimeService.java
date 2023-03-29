package com.company.hospitalmanagementsystem.services.inter;

import com.company.hospitalmanagementsystem.models.WorkTime;

public interface WorkTimeService {
    WorkTime getByDoctorFinCodeAndLocalDate(String finCode, String week);
    WorkTime getByDoctorFinCode(String finCode);
}
