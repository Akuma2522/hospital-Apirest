package com.backendHospital.hospital_Apirest.dto;

import com.backendHospital.hospital_Apirest.enums.TipoMantenimiento;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EquipoUpdateDto {

    private String estado;
    private Long idServicio;
    private Long idTaller;
    private LocalDate ultimoMantenimiento;
    private TipoMantenimiento tipoMantenimiento;
}
