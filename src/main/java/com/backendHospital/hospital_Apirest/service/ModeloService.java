package com.backendHospital.hospital_Apirest.service;

import com.backendHospital.hospital_Apirest.dto.ModeloRequestDto;
import com.backendHospital.hospital_Apirest.dto.ModeloResponseDto;
import java.util.List;

public interface ModeloService {
    List<ModeloResponseDto> findAll();
    ModeloResponseDto findById(Long id);
    ModeloResponseDto create(ModeloRequestDto dto);
    ModeloResponseDto update(Long id, ModeloRequestDto dto);
    void delete(Long id);
}
