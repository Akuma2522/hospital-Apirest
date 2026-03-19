package com.backendHospital.hospital_Apirest.dto;

import lombok.*;
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class TecnicoRequestDto {
    private String nombre;
    private String telefono;
    private String horario;
    private Long idTaller;
    private Long idUsuario;
}
