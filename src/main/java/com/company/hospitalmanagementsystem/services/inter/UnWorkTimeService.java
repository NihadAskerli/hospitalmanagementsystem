package com.company.hospitalmanagementsystem.services.inter;

import com.company.hospitalmanagementsystem.models.UnWorkTime;

import java.time.DayOfWeek;

public interface UnWorkTimeService {
    UnWorkTime getByDoctorFinCodeAndLocalDate(String finCode, String week);
}
