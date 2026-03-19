package com.backendHospital.hospital_Apirest.dto;

import com.backendHospital.hospital_Apirest.enums.TipoMantenimiento;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EquipoDetalleDto {
    private Long id;
    private String codigoPatrimonial;
    private String denominacionEspecifica;
    private String marca;
    private String modelo;
    private String serie;
    private String estado;
    private String taller;
    private String hospital;
    private Integer frecuenciaMantenimiento;
    private LocalDate ultimoMantenimiento;
    private LocalDate proximoMantenimiento;
    private TipoMantenimiento tipoMantenimiento;
    private String servicio;
}
