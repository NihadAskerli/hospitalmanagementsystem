package com.company.hospitalmanagementsystem.repo;

import com.company.hospitalmanagementsystem.models.WorkTime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkTimeRepository extends JpaRepository<WorkTime,Long> {
    WorkTime getByDoctorFinCodeAndAndWeekOfDay(String doctorFinCode, String dayOfWeek);
    WorkTime getByDoctorFinCode(String doctorFinCode);
}
