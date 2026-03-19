package com.backendHospital.hospital_Apirest.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tecnico")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tecnico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tecnico")
    private Long id;

    private String nombre;
    private String telefono;
    private String horario;

    @ManyToOne
    @JoinColumn(name = "id_taller")
    private Taller taller;


    @OneToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;
}
