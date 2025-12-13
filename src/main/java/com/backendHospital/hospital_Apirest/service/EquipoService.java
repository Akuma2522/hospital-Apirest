package com.backendHospital.hospital_Apirest.service;

import com.backendHospital.hospital_Apirest.dto.EquipoDetalleDto;
import com.backendHospital.hospital_Apirest.dto.EquipoRequestDto;
import com.backendHospital.hospital_Apirest.dto.EquipoResponseDto;
import com.backendHospital.hospital_Apirest.dto.EquipoUpdateDto;

import java.util.List;

public interface EquipoService {
    List<EquipoDetalleDto> findAll();
    EquipoDetalleDto findById(Long id);
//    EquipoResponseDto create(EquipoRequestDto dto);
    EquipoDetalleDto update(Long id, EquipoUpdateDto dto);
    void delete(Long id);

    EquipoDetalleDto buscarPorCodigoPatrimonial(String codigo);
}
