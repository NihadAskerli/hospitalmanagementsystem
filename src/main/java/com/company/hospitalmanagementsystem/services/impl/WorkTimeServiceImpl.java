package com.company.hospitalmanagementsystem.services.impl;

import com.company.hospitalmanagementsystem.models.Examination;
import com.company.hospitalmanagementsystem.models.WorkTime;
import com.company.hospitalmanagementsystem.repo.WorkTimeRepository;
import com.company.hospitalmanagementsystem.services.inter.WorkTimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkTimeServiceImpl implements WorkTimeService {
    private final WorkTimeRepository unWorkTimeRepository;
    private final ExaminationImplService examinationImplService;
    @Override
    public WorkTime getByDoctorFinCodeAndLocalDate(String finCode, String week) {
        return unWorkTimeRepository.getByDoctorFinCodeAndAndWeekOfDay(finCode,week);
    }

    @Override
    public WorkTime getByDoctorFinCode(String finCode) {
        return unWorkTimeRepository.getByDoctorFinCode(finCode);
    }

    public List<String> keepTimes(Examination examination){
        List<String> times=new ArrayList<>();
        List<Examination> examinations=examinationImplService.getKeepExaminations(examination.getLocalDate(),examination.getDoctorFinCode());
        for (Examination keepExamination:
             examinations) {
            times.add(keepExamination.getTime());
        }
        return times;
    }
}
