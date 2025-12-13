package com.backendHospital.hospital_Apirest.service;

import com.backendHospital.hospital_Apirest.dto.TecnicoRequestDto;
import com.backendHospital.hospital_Apirest.dto.TecnicoResponseDto;
import java.util.List;

public interface TecnicoService {
    List<TecnicoResponseDto> findAll();
    TecnicoResponseDto findById(Long id);
    TecnicoResponseDto create(TecnicoRequestDto dto);
    TecnicoResponseDto update(Long id, TecnicoRequestDto dto);
    void delete(Long id);
}
