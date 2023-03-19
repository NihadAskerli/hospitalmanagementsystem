package com.company.hospitalmanagementsystem.dto;

import com.company.hospitalmanagementsystem.models.Hospital;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssistantDto {
    private String name;
    private String  finCode;
    private String surname;
    private String cardId;
    private Hospital hospital;
}
