package com.company.hospitalmanagementsystem.services.impl;

import com.amazonaws.services.dynamodbv2.xspec.B;
import com.company.hospitalmanagementsystem.models.*;
import com.company.hospitalmanagementsystem.repo.SalaryRepository;
import com.company.hospitalmanagementsystem.services.inter.SalaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SalaryServiceImpl implements SalaryService {
    private final SalaryRepository salaryRepository;
    private final DoctorServiceImpl doctorService;
    private final PaymentServiceImpl paymentService;
    private final HospitalServiceImpl hospitalService;
    private final AssistantServiceImpl assistantService;
    private final ExaminationImplService examinationImplService;


    @Scheduled(cron = "0 0 3 28 * ?")
    public void salaryBudget() {
        List<Doctor> doctors=doctorService.getAllDoctor();
        BigDecimal allSalary=new BigDecimal(0.0);
        for (Doctor doctor:doctors
        ) {
            Double salary=examinationImplService.getAllByFinCode(doctor.getFinCode()).size()*doctor.getExaminationPay().doubleValue();
            System.out.println(BigDecimal.valueOf(salary));
           BigDecimal salary1=BigDecimal.valueOf(salary);
           BigDecimal salaryEnd=allSalary.add(salary1);
           allSalary=salaryEnd;
        }
        hospitalService.updateBudget("healthlife",allSalary);
    }

    @Scheduled(cron = "0 0 4 28 * ?")
    public void salaryAssistant() {
        List<Assistant> assistants = assistantService.getAllAssistant();
        Hospital hospital=hospitalService.getByName("healthlife");
        BigDecimal allSalary=hospital.getBudget();
        for (Assistant assistant : assistants
        ) {
            save(assistant.getCardId(),BigDecimal.valueOf(500l));
        }
        Integer salary=assistants.size()*350;
        BigDecimal newBudget=allSalary.subtract(BigDecimal.valueOf(salary.longValue()));
        hospitalService.updateBudget("healthlife",newBudget);
    }
    @Scheduled(cron = "0 0 5 28 * ?")
    public void salaryDoctor(){
        List<Doctor> doctors=doctorService.getAllDoctor();
        BigDecimal allSalary= hospitalService.getByName("healthlife").getBudget();
        for (Doctor doctor:doctors
             ) {
            Double salary=examinationImplService.getAllByFinCode(doctor.getFinCode()).size()*doctor.getExaminationPay().doubleValue()*0.7;
            save(doctor.getCardId(),BigDecimal.valueOf(salary.longValue()));
            BigDecimal salaryDoctor=BigDecimal.valueOf(salary);
            System.out.println(salaryDoctor);
            BigDecimal salaryEnd=allSalary.subtract(salaryDoctor);
            System.out.println(salaryEnd);
            hospitalService.updateBudget("healthlife",salaryEnd);
            examinationImplService.deleteAllByFinCode(doctor.getFinCode());
        }
    }

    @Override
    public void save(String cardId, BigDecimal salary) {
        salaryRepository.save(new Salary(null, cardId, salary, LocalDate.now()));
    }

}


