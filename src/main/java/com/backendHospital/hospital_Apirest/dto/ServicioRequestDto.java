package com.backendHospital.hospital_Apirest.dto;

import lombok.*;
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class ServicioRequestDto {
    private Long idUnidad;
    private String nombre;
    private String jefeServicio;
    private String celularJefe;
}
