package com.backendHospital.hospital_Apirest.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "servicio")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_servicio")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_unidad")
    private UnidadPrestadora unidad;

    private String nombre;

    @Column(name = "jefe_servicio")
    private String jefeServicio;

    @Column(name = "celular_jefe")
    private String celularJefe;
}
