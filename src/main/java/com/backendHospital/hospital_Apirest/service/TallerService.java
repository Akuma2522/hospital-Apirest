package com.backendHospital.hospital_Apirest.service;

import com.backendHospital.hospital_Apirest.dto.TallerRequestDto;
import com.backendHospital.hospital_Apirest.dto.TallerResponseDto;
import java.util.List;
public interface TallerService {
    List<TallerResponseDto> findAll();
    TallerResponseDto findById(Long id);
    TallerResponseDto create(TallerRequestDto dto);
    TallerResponseDto update(Long id, TallerRequestDto dto);
    void delete(Long id);
}
