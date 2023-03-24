package com.company.hospitalmanagementsystem.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "salary")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Salary {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_salary")
    @SequenceGenerator(
            name = "seq_salary", allocationSize = 1
    )
    private Long id;
    private String cardId;
    private BigDecimal salary;
    private LocalDate date;
}





