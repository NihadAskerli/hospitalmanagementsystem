package com.company.hospitalmanagementsystem;

import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class HospitalmanagementsystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(HospitalmanagementsystemApplication.class, args);
    }

}
