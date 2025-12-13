package com.backendHospital.hospital_Apirest.service;

import com.backendHospital.hospital_Apirest.dto.ModeloRequestDto;
import com.backendHospital.hospital_Apirest.dto.ModeloResponseDto;
import com.backendHospital.hospital_Apirest.model.Marca;
import com.backendHospital.hospital_Apirest.model.Modelo;
import com.backendHospital.hospital_Apirest.repository.MarcaRepository;
import com.backendHospital.hospital_Apirest.repository.ModeloRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ModeloServiceImpl implements ModeloService {

    private final ModeloRepository repo;
    private final MarcaRepository marcaRepo;

    private ModeloResponseDto toDto(Modelo m){
        return ModeloResponseDto.builder()
                .id(m.getId())
                .idMarca(m.getMarca() != null ? m.getMarca().getId() : null)
                .nombre(m.getNombre())
                .build();
    }

    @Override
    public List<ModeloResponseDto> findAll() {
        return repo.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public ModeloResponseDto findById(Long id) {
        Modelo m = repo.findById(id).orElseThrow(() -> new RuntimeException("Modelo not found"));
        return toDto(m);
    }

    @Override
    public ModeloResponseDto create(ModeloRequestDto dto) {
        Modelo m = Modelo.builder().nombre(dto.getNombre()).build();
        if (dto.getIdMarca() != null) {
            Marca marca = marcaRepo.findById(dto.getIdMarca()).orElseThrow(() -> new RuntimeException("Marca not found"));
            m.setMarca(marca);
        }
        return toDto(repo.save(m));
    }

    @Override
    public ModeloResponseDto update(Long id, ModeloRequestDto dto) {
        Modelo m = repo.findById(id).orElseThrow(() -> new RuntimeException("Modelo not found"));
        m.setNombre(dto.getNombre());
        if (dto.getIdMarca() != null) {
            Marca marca = marcaRepo.findById(dto.getIdMarca()).orElseThrow(() -> new RuntimeException("Marca not found"));
            m.setMarca(marca);
        } else {
            m.setMarca(null);
        }
        return toDto(repo.save(m));
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
