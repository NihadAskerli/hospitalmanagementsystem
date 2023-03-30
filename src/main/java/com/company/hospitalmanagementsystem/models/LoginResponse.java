package com.company.hospitalmanagementsystem.models;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Getter
@Builder
public class LoginResponse {
private final String accessToken;
}
