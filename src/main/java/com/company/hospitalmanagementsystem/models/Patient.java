package com.company.hospitalmanagementsystem.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "patients")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_patients")
    @SequenceGenerator(
            name = "seq_patients", allocationSize = 1
    )
    private Long id;
    private String patientName;
    private String patientSurname;
    private String email;
    private String phone;
    private String address;
    private LocalDate beginDate;
    private LocalDate endDate;
    @ManyToOne
    @JoinColumn(name = "doctor_id", referencedColumnName = "id")
    @JsonIgnore
    private Doctor doctor;
}
