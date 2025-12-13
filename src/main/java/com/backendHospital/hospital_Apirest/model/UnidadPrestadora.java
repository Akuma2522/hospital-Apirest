package com.backendHospital.hospital_Apirest.model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "unidad_prestadora")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UnidadPrestadora {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_unidad")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_organo")
    private OrganoDesconcentrado organo;

    private String nombre;
    private String jefeIngenieria;

    @Column(name = "celular_jefe")
    private String celularJefe;

    @Column(name = "correo_jefe")
    private String correoJefe;
}
