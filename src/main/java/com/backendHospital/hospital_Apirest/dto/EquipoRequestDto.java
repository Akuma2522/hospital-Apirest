package com.backendHospital.hospital_Apirest.dto;

import com.backendHospital.hospital_Apirest.enums.EstadoEquipo;
import com.backendHospital.hospital_Apirest.enums.TipoMantenimiento;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class EquipoRequestDto {
    private String codigoPatrimonial;
    private String denominacionGeneral;
    private String denominacionEspecifica;
    private Long idMarca;
    private Long idModelo;
    private String serie;
    private String tipoEquipamiento;
    private String criticidad;
    private EstadoEquipo estado;
    private String modalidadEjecucion;
    private Long idTaller;
    private Long idTecnico;
    private Integer anioAdquisicion;
    private Integer vidaUtilYears;
    private Long idProveedor;
    private LocalDate fechaRecepcion;
    private Long idServicio;
    private LocalDate ultimoMantenimiento;
    private TipoMantenimiento tipoMantenimiento;
    private Long equipoPrincipalId;
}
