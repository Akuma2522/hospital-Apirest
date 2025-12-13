package com.backendHospital.hospital_Apirest.dto;

import lombok.*;
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class UnidadPrestadoraRequestDto {
    private Long idOrgano; // id_organo
    private String nombre;
    private String jefeIngenieria;
    private String celularJefe;
    private String correoJefe;
}
