package com.company.hospitalmanagementsystem.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private String pastTreatment;
    private LocalDate localDate;
    private String time;
    private String customFinCode;
}
