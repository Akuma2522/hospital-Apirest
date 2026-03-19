package com.backendHospital.hospital_Apirest.repository;

import com.backendHospital.hospital_Apirest.model.Dispositivo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DispositivoRepository extends JpaRepository<Dispositivo, Long> {

    Dispositivo findByToken(String token);

    List<Dispositivo> findByUsuarioId(Long idUsuario);
}