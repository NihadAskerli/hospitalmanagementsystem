package com.company.hospitalmanagementsystem.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_assistants")
    @SequenceGenerator(
            name = "seq_assistants", allocationSize = 1
    )
    private Long id;
    private String finCode;
    private String name;
    private String surname;
    private String cardId;
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "hospital_id",referencedColumnName = "id")
    @JsonIgnore
    private Hospital hospital;


}