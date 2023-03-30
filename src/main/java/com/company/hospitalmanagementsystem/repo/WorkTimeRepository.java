package com.company.hospitalmanagementsystem.repo;

import com.company.hospitalmanagementsystem.models.WorkTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WorkTimeRepository extends JpaRepository<WorkTime,Long> {
    WorkTime getByDoctorFinCodeAndAndWeekOfDay(String doctorFinCode, String dayOfWeek);
    WorkTime getByDoctorFinCode(String doctorFinCode);
}
