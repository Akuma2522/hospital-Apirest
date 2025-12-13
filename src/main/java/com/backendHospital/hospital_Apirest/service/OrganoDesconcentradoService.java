package com.backendHospital.hospital_Apirest.service;

import com.backendHospital.hospital_Apirest.dto.OrganoDesconcentradoRequestDto;
import com.backendHospital.hospital_Apirest.dto.OrganoDesconcentradoResponseDto;

import java.util.List;
public interface OrganoDesconcentradoService {
    List<OrganoDesconcentradoResponseDto> findAll();
    OrganoDesconcentradoResponseDto findById(Long id);
    OrganoDesconcentradoResponseDto create(OrganoDesconcentradoRequestDto dto);
    OrganoDesconcentradoResponseDto update(Long id, OrganoDesconcentradoRequestDto dto);
    void delete(Long id);
}