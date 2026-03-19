package com.backendHospital.hospital_Apirest.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "usuario")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    private String rol;

    @OneToOne(mappedBy = "usuario")
    private Tecnico tecnico;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER)
    private List<Dispositivo> dispositivos;
}
