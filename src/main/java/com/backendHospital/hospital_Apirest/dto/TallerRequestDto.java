package com.backendHospital.hospital_Apirest.dto;

import lombok.*;
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class TallerRequestDto {
    private String nombre;
    private String residente;
    private String telefonoResidente;
    private String correo;
    private Long idProveedor;
}
