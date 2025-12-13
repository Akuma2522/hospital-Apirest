package com.backendHospital.hospital_Apirest.dto;

import lombok.*;
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class ModeloResponseDto {
    private Long id;
    private Long idMarca;
    private String nombre;
}
