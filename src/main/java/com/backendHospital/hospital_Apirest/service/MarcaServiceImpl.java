package com.backendHospital.hospital_Apirest.service;

import com.backendHospital.hospital_Apirest.dto.MarcaRequestDto;
import com.backendHospital.hospital_Apirest.dto.MarcaResponseDto;
import com.backendHospital.hospital_Apirest.model.Marca;
import com.backendHospital.hospital_Apirest.repository.MarcaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MarcaServiceImpl implements MarcaService {

    private final MarcaRepository repo;

    private MarcaResponseDto toDto(Marca m){
        return MarcaResponseDto.builder()
                .id(m.getId())
                .nombre(m.getNombre())
                .build();
    }

    @Override
    public List<MarcaResponseDto> findAll() {
        return repo.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public MarcaResponseDto findById(Long id) {
        Marca m = repo.findById(id).orElseThrow(() -> new RuntimeException("Marca not found"));
        return toDto(m);
    }

    @Override
    public MarcaResponseDto create(MarcaRequestDto dto) {
        Marca m = Marca.builder().nombre(dto.getNombre()).build();
        return toDto(repo.save(m));
    }

    @Override
    public MarcaResponseDto update(Long id, MarcaRequestDto dto) {
        Marca m = repo.findById(id).orElseThrow(() -> new RuntimeException("Marca not found"));
        m.setNombre(dto.getNombre());
        return toDto(repo.save(m));
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
