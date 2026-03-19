package com.backendHospital.hospital_Apirest.dto;

import com.backendHospital.hospital_Apirest.enums.TipoMantenimiento;
import lombok.*;
import java.time.LocalDate;
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class EquipoResponseDto {
    private Long id;
    private String codigoPatrimonial;
    private String denominacionGeneral;
    private String denominacionEspecifica;
    private String marca;
    private String modelo;
    private String serie;
    private String tipoEquipamiento;
    private String criticidad;
    private String estado;
    private String modalidadEjecucion;
    private Long idTaller;
    private Long idTecnico;
    private Integer anioAdquisicion;
    private Integer vidaUtilYears;
    private Long idProveedor;
    private LocalDate fechaRecepcion;
    private Long idHospital;
    private Integer frecuenciaMantenimiento;
    private LocalDate ultimoMantenimiento;
    private LocalDate proximoMantenimiento;
    private TipoMantenimiento tipoMantenimiento;
    private Long idServicio;
    private Long equipoPrincipalId;
}
