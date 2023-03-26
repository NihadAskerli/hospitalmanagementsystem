package com.company.hospitalmanagementsystem.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "assistants")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Assistant {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_hospitals")
    @SequenceGenerator(
            name = "seq_hospitals", allocationSize = 1
    )
    private Long id;
    private String finCode;
    private String name;
    private String surname;
    private String cardId;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "hospital_id",referencedColumnName = "id")
    private Hospital hospital;


}