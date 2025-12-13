package com.backendHospital.hospital_Apirest.repository;

import com.backendHospital.hospital_Apirest.model.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TecnicoRepository extends JpaRepository<Tecnico,Long> {
}
