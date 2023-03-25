package com.company.hospitalmanagementsystem.repo;

import com.company.hospitalmanagementsystem.models.UnWorkTime;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.DayOfWeek;

public interface UnWorkTimeRepository extends JpaRepository<UnWorkTime,Long> {
    UnWorkTime getByDoctorFinCodeAndAndWeekOfDay(String doctorFinCode, String dayOfWeek);
}
