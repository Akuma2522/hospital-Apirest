package com.backendHospital.hospital_Apirest.repository;

import com.backendHospital.hospital_Apirest.dto.ServicioResponseDto;
import com.backendHospital.hospital_Apirest.model.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServicioRepository extends JpaRepository<Servicio,Long> {
    List<Servicio> findByUnidad_Id(Long idUnidad);
    boolean existsByUnidad(Long unidad);
}
