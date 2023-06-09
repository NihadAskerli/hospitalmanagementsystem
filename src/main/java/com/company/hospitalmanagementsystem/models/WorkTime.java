package com.company.hospitalmanagementsystem.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "worktimes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkTime {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_doctors")
    @SequenceGenerator(
            name = "seq_doctors", allocationSize = 1
    )
    private Long id;
    private String weekOfDay;
    @ElementCollection
    @CollectionTable(name = "times", joinColumns = @JoinColumn(name = "time_id"))
    @Column(name = "day_of_time")
    private List<String> times;
    private String doctorFinCode;
}
