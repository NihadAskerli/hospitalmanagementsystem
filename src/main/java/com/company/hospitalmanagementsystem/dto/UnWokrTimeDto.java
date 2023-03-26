package com.company.hospitalmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UnWokrTimeDto {
    private Long id;
    private List<String> times;
}
