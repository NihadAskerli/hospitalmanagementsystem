package com.company.hospitalmanagementsystem.models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "salary")
public class Salary {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_salary")
    @SequenceGenerator(
            name = "seq_salary", allocationSize = 1
    )
    private Long id;
    private String cardId;
    private BigDecimal salary;
    private Date date;
}





