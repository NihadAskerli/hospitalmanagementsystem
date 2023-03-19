package com.company.hospitalmanagementsystem.models;

import jakarta.persistence.*;

@Entity
@Table(name = "examinations")
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
    private String date;
}
