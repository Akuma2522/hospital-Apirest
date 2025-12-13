package com.backendHospital.hospital_Apirest.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "organo_desconcentrado")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrganoDesconcentrado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_organo")
    private Long id;

    private String nombre;
}
