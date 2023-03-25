package com.company.hospitalmanagementsystem.services.impl;

import com.company.hospitalmanagementsystem.models.Examination;
import com.company.hospitalmanagementsystem.models.UnWorkTime;
import com.company.hospitalmanagementsystem.repo.UnWorkTimeRepository;
import com.company.hospitalmanagementsystem.services.inter.UnWorkTimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UnWorkTimeServiceImpl implements UnWorkTimeService {
    private final UnWorkTimeRepository unWorkTimeRepository;
    private final ExaminationImplService examinationImplService;
    @Override
    public UnWorkTime getByDoctorFinCodeAndLocalDate(String finCode, String week) {
        return unWorkTimeRepository.getByDoctorFinCodeAndAndWeekOfDay(finCode,week);
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
