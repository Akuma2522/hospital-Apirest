package com.backendHospital.hospital_Apirest.service;

import com.backendHospital.hospital_Apirest.dto.ProveedorRequestDto;
import com.backendHospital.hospital_Apirest.dto.ProveedorResponseDto;
import java.util.List;

public interface ProveedorService {
    List<ProveedorResponseDto> findAll();
    ProveedorResponseDto findById(Long id);
    ProveedorResponseDto create(ProveedorRequestDto dto);
    ProveedorResponseDto update(Long id, ProveedorRequestDto dto);
    void delete(Long id);
}
