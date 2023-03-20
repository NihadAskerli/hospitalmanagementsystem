package com.company.hospitalmanagementsystem;

import com.company.hospitalmanagementsystem.services.impl.DoctorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HospitalmanagementsystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(HospitalmanagementsystemApplication.class, args);
    }

}
