package com.company.hospitalmanagementsystem.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "payments")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_payments")
    @SequenceGenerator(
            name = "seq_payments", allocationSize = 1
    )
    private Long id;
    private String cardId;
    private String cardCode;
    private String endTime;
    private BigDecimal pay;
    private LocalDate date;
}
