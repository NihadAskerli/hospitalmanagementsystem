package com.company.hospitalmanagementsystem.models;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "insurances")
public class Insurance {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_insurances")
    @SequenceGenerator(
            name = "seq_insurances", allocationSize = 1
    )
    private Long id;
    private String companyName;
    private String finCode;


}
