package com.backendHospital.hospital_Apirest.model;
import com.backendHospital.hospital_Apirest.enums.EstadoEquipo;
import com.backendHospital.hospital_Apirest.enums.TipoMantenimiento;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "equipo")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Equipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_equipo")
    private Long id;
    private String codigoPatrimonial;
    private String denominacionGeneral;
    private String denominacionEspecifica;

    @ManyToOne
    @JoinColumn(name = "marca_id", nullable = false)
    private Marca marca;

    @ManyToOne
    @JoinColumn(name = "modelo_id", nullable = false)
    private Modelo modelo;

    @NonNull
    private String serie;

    @Column(name = "tipo_equipamiento")
    private String tipoEquipamiento;

    @NonNull
    private String criticidad;

    @Enumerated(EnumType.STRING)
    private EstadoEquipo estado;

    @Column(name = "modalidad_ejecucion")
    private String modalidadEjecucion;

    @ManyToOne
    @JoinColumn(name = "id_taller", nullable = false)
    private Taller taller;

    @ManyToOne
    @JoinColumn(name = "id_tecnico", nullable = false)
    private Tecnico tecnico;

    @Column(name = "año_adquisicion")
    private Integer anioAdquisicion;

    @Column(name = "vida_util_years")
    private Integer vidaUtilYears;

    @ManyToOne
    @JoinColumn(name = "proveedor_id", nullable = false)
    private Proveedor proveedor;

    @Column(name = "fecha_recepcion")
    private LocalDate fechaRecepcion;

    @ManyToOne
    @JoinColumn(name = "servicio_id", nullable = false)
    private Servicio servicio;

    @Column(name = "ultimo_mantenimiento")
    private LocalDate ultimoMantenimiento;

    @Enumerated(EnumType.STRING)
    private TipoMantenimiento tipoMantenimiento;

    // Equipo que contiene a este equipo (si es componente)
    @ManyToOne
    @JoinColumn(name = "equipo_principal_id")
    private Equipo equipoPrincipal;
}
