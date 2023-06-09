package com.company.hospitalmanagementsystem.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.Temporal;

import java.time.LocalDate;

@Entity
@Table(name = "examinations")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Examination {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_salary")
    @SequenceGenerator(
            name = "seq_salary", allocationSize = 1
    )
    private Long id;
    private String doctorFinCode;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private String registerEmail;
    private String pastTreatment;
    private LocalDate localDate;
    private String time;
    private String customFinCode;

}
