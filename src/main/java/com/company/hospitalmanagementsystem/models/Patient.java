package com.company.hospitalmanagementsystem.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private String date;
    @ManyToOne
    @JoinColumn(name = "doctor_id", referencedColumnName = "id")
    @JsonIgnore
    private Doctor doctor;
}
