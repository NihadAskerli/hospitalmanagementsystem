package com.company.hospitalmanagementsystem.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "doctors")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_doctors")
    @SequenceGenerator(
            name = "seq_doctors", allocationSize = 1
    )
    private Long id;
    private String branch;
    private String cardId;
    private String name;
    private String surname;
    private String finCode;
    private String unWorking;
    @OneToOne
    @JoinColumn(name = "department_id")
    private Department department;
    @OneToOne
    @JoinColumn(name = "photo_id")
    private Photo photo;
    @ManyToOne
    @JoinColumn(name = "hospital_id",referencedColumnName = "id")
    @JsonIgnore
    private Hospital hospital;
    @OneToMany(mappedBy = "doctor",cascade = CascadeType.ALL)
    private List<Patient> patient;

}
