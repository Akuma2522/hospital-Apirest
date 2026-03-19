package com.backendHospital.hospital_Apirest.repository;

import com.backendHospital.hospital_Apirest.model.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface EquipoRepository extends JpaRepository<Equipo,Long> {
    Optional<Equipo> findByCodigoPatrimonial(String codigoPatrimonial);
    boolean existsByCodigoPatrimonial(String codigoPatrimonial);
    List<Equipo> findByProximoMantenimientoLessThanEqual(LocalDate fecha);
}
