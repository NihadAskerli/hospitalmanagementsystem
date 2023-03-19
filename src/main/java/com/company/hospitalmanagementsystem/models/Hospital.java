package com.company.hospitalmanagementsystem.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "hospitals")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_hospitals")
    @SequenceGenerator(
            name = "seq_hospitals", allocationSize = 1
    )
    private Long id;
    private String name;
    private String address;
    private String email;
    private BigDecimal budget;
    @OneToMany(mappedBy = "hospital",cascade = CascadeType.ALL)
    private List<Doctor> doctors;
    @OneToMany(mappedBy = "hospital")
    private List<Assistant> assistants;

}
