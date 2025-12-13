package com.backendHospital.hospital_Apirest.service;

import com.backendHospital.hospital_Apirest.dto.UnidadPrestadoraRequestDto;
import com.backendHospital.hospital_Apirest.dto.UnidadPrestadoraResponseDto;
import com.backendHospital.hospital_Apirest.model.OrganoDesconcentrado;
import com.backendHospital.hospital_Apirest.model.UnidadPrestadora;
import com.backendHospital.hospital_Apirest.repository.OrganoDesconcentradoRepository;
import com.backendHospital.hospital_Apirest.repository.UnidadPrestadoraRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UnidadPrestadoraServiceImpl implements UnidadPrestadoraService {

    private final UnidadPrestadoraRepository repo;
    private final OrganoDesconcentradoRepository organoRepo;

    private UnidadPrestadoraResponseDto toDto(UnidadPrestadora e){
        return UnidadPrestadoraResponseDto.builder()
                .id(e.getId())
                .nombre(e.getNombre())
                .build();
    }

    @Override
    public List<UnidadPrestadoraResponseDto> findAll() {
        return repo.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public UnidadPrestadoraResponseDto findById(Long id) {
        UnidadPrestadora e = repo.findById(id).orElseThrow(() -> new RuntimeException("Unidad not found"));
        return toDto(e);
    }

    @Override
    public UnidadPrestadoraResponseDto create(UnidadPrestadoraRequestDto dto) {
        UnidadPrestadora e = UnidadPrestadora.builder()
                .nombre(dto.getNombre())
                .jefeIngenieria(dto.getJefeIngenieria())
                .celularJefe(dto.getCelularJefe())
                .correoJefe(dto.getCorreoJefe())
                .build();
        if (dto.getIdOrgano() != null) {
            OrganoDesconcentrado o = organoRepo.findById(dto.getIdOrgano()).orElseThrow(() -> new RuntimeException("Organo not found"));
            e.setOrgano(o);
        }
        return toDto(repo.save(e));
    }

    @Override
    public UnidadPrestadoraResponseDto update(Long id, UnidadPrestadoraRequestDto dto) {
        UnidadPrestadora e = repo.findById(id).orElseThrow(() -> new RuntimeException("Unidad not found"));
        e.setNombre(dto.getNombre());
        e.setJefeIngenieria(dto.getJefeIngenieria());
        e.setCelularJefe(dto.getCelularJefe());
        e.setCorreoJefe(dto.getCorreoJefe());
        if (dto.getIdOrgano() != null) {
            OrganoDesconcentrado o = organoRepo.findById(dto.getIdOrgano()).orElseThrow(() -> new RuntimeException("Organo not found"));
            e.setOrgano(o);
        } else {
            e.setOrgano(null);
        }
        return toDto(repo.save(e));
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}