package com.backendHospital.hospital_Apirest.service;

import com.backendHospital.hospital_Apirest.dto.ProveedorRequestDto;
import com.backendHospital.hospital_Apirest.dto.ProveedorResponseDto;
import com.backendHospital.hospital_Apirest.model.Proveedor;
import com.backendHospital.hospital_Apirest.repository.ProveedorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProveedorServiceImpl implements ProveedorService {

    private final ProveedorRepository repo;

    private ProveedorResponseDto toDto(Proveedor p){
        return ProveedorResponseDto.builder()
                .id(p.getId())
                .razonSocial(p.getRazonSocial())
                .ruc(p.getRuc())
                .build();
    }

    @Override
    public List<ProveedorResponseDto> findAll() {
        return repo.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public ProveedorResponseDto findById(Long id) {
        Proveedor p = repo.findById(id).orElseThrow(() -> new RuntimeException("Proveedor not found"));
        return toDto(p);
    }

    @Override
    public ProveedorResponseDto create(ProveedorRequestDto dto) {
        Proveedor p = Proveedor.builder()
                .razonSocial(dto.getRazonSocial())
                .ruc(dto.getRuc())
                .build();
        return toDto(repo.save(p));
    }

    @Override
    public ProveedorResponseDto update(Long id, ProveedorRequestDto dto) {
        Proveedor p = repo.findById(id).orElseThrow(() -> new RuntimeException("Proveedor not found"));
        p.setRazonSocial(dto.getRazonSocial());
        p.setRuc(dto.getRuc());
        return toDto(repo.save(p));
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
