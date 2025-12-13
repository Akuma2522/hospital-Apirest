package com.backendHospital.hospital_Apirest.dto;

import lombok.*;
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class ProveedorResponseDto {
    private Long id;
    private String razonSocial;
    private String ruc;
}
