package com.backendHospital.hospital_Apirest.model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "marca")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_marca")
    private Long id;

    private String nombre;
}
