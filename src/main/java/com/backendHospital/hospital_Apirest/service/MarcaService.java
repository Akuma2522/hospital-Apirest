package com.backendHospital.hospital_Apirest.service;


import com.backendHospital.hospital_Apirest.dto.MarcaRequestDto;
import com.backendHospital.hospital_Apirest.dto.MarcaResponseDto;

import java.util.List;
public interface MarcaService {
    List<MarcaResponseDto> findAll();
    MarcaResponseDto findById(Long id);
    MarcaResponseDto create(MarcaRequestDto dto);
    MarcaResponseDto update(Long id, MarcaRequestDto dto);
    void delete(Long id);
}
