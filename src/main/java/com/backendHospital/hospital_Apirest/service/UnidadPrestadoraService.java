package com.backendHospital.hospital_Apirest.service;

import com.backendHospital.hospital_Apirest.dto.UnidadPrestadoraRequestDto;
import com.backendHospital.hospital_Apirest.dto.UnidadPrestadoraResponseDto;
import java.util.List;

public interface UnidadPrestadoraService {
    List<UnidadPrestadoraResponseDto> findAll();
    UnidadPrestadoraResponseDto findById(Long id);
    UnidadPrestadoraResponseDto create(UnidadPrestadoraRequestDto dto);
    UnidadPrestadoraResponseDto update(Long id, UnidadPrestadoraRequestDto dto);
    void delete(Long id);
}