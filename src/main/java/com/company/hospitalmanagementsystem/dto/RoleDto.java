package com.company.hospitalmanagementsystem.dto;

import com.company.hospitalmanagementsystem.models.LoginResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleDto {
    private Long id;
    private List<String> roles;
    private LoginResponse token;
}
