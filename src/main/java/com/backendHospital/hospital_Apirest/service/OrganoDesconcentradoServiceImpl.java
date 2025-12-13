package com.backendHospital.hospital_Apirest.service;

import com.backendHospital.hospital_Apirest.dto.OrganoDesconcentradoRequestDto;
import com.backendHospital.hospital_Apirest.dto.OrganoDesconcentradoResponseDto;
import com.backendHospital.hospital_Apirest.model.OrganoDesconcentrado;
import com.backendHospital.hospital_Apirest.repository.OrganoDesconcentradoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrganoDesconcentradoServiceImpl implements OrganoDesconcentradoService {

    private final OrganoDesconcentradoRepository repo;

    private OrganoDesconcentradoResponseDto toDto(OrganoDesconcentrado e){
        return OrganoDesconcentradoResponseDto.builder()
                .id(e.getId())
                .nombre(e.getNombre())
                .build();
    }

    @Override
    public List<OrganoDesconcentradoResponseDto> findAll() {
        return repo.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public OrganoDesconcentradoResponseDto findById(Long id) {
        OrganoDesconcentrado e = repo.findById(id).orElseThrow(() -> new RuntimeException("Organo not found"));
        return toDto(e);
    }

    @Override
    public OrganoDesconcentradoResponseDto create(OrganoDesconcentradoRequestDto dto) {
        OrganoDesconcentrado e = OrganoDesconcentrado.builder()
                .nombre(dto.getNombre())
                .build();
        return toDto(repo.save(e));
    }

    @Override
    public OrganoDesconcentradoResponseDto update(Long id, OrganoDesconcentradoRequestDto dto) {
        OrganoDesconcentrado e = repo.findById(id).orElseThrow(() -> new RuntimeException("Organo not found"));
        e.setNombre(dto.getNombre());
        return toDto(repo.save(e));
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}