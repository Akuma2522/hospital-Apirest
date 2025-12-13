package com.backendHospital.hospital_Apirest.service;

import com.backendHospital.hospital_Apirest.dto.ServicioRequestDto;
import com.backendHospital.hospital_Apirest.dto.ServicioResponseDto;
import com.backendHospital.hospital_Apirest.model.Servicio;

import java.util.List;
public interface ServicioService {
    List<ServicioResponseDto> findAll();
    ServicioResponseDto findById(Long id);
    List<ServicioResponseDto> findByUnidad(Long unidad);
    ServicioResponseDto create(ServicioRequestDto dto);
    ServicioResponseDto update(Long id, ServicioRequestDto dto);
    void delete(Long id);
}