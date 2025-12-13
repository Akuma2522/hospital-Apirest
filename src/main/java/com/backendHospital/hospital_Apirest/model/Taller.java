package com.backendHospital.hospital_Apirest.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "taller")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Taller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_taller")
    private Long id;

    private String nombre;
    private String residente;

    @Column(name = "telefono_residente")
    private String telefonoResidente;

    private String correo;

    @ManyToOne
    @JoinColumn(name = "id_proveedor")
    private Proveedor proveedor;
}
