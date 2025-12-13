package com.backendHospital.hospital_Apirest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponseDto {
    private Long id;
    private String username;
    private String rol;
}
