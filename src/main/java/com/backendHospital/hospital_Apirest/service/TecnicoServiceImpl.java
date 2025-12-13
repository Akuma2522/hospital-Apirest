package com.backendHospital.hospital_Apirest.service;

import com.backendHospital.hospital_Apirest.dto.TecnicoRequestDto;
import com.backendHospital.hospital_Apirest.dto.TecnicoResponseDto;
import com.backendHospital.hospital_Apirest.model.Taller;
import com.backendHospital.hospital_Apirest.model.Tecnico;
import com.backendHospital.hospital_Apirest.repository.TallerRepository;
import com.backendHospital.hospital_Apirest.repository.TecnicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TecnicoServiceImpl implements TecnicoService {

    private final TecnicoRepository repo;
    private final TallerRepository tallerRepo;

    private TecnicoResponseDto toDto(Tecnico t){
        return TecnicoResponseDto.builder()
                .id(t.getId())
                .nombre(t.getNombre())
                .telefono(t.getTelefono())
                .horario(t.getHorario())
                .idTaller(t.getTaller() != null ? t.getTaller().getId() : null)
                .build();
    }

    @Override
    public List<TecnicoResponseDto> findAll() {
        return repo.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public TecnicoResponseDto findById(Long id) {
        Tecnico t = repo.findById(id).orElseThrow(() -> new RuntimeException("Tecnico not found"));
        return toDto(t);
    }

    @Override
    public TecnicoResponseDto create(TecnicoRequestDto dto) {
        Tecnico t = Tecnico.builder()
                .nombre(dto.getNombre())
                .telefono(dto.getTelefono())
                .horario(dto.getHorario())
                .build();
        if (dto.getIdTaller() != null) {
            Taller ta = tallerRepo.findById(dto.getIdTaller()).orElseThrow(() -> new RuntimeException("Taller not found"));
            t.setTaller(ta);
        }
        return toDto(repo.save(t));
    }

    @Override
    public TecnicoResponseDto update(Long id, TecnicoRequestDto dto) {
        Tecnico t = repo.findById(id).orElseThrow(() -> new RuntimeException("Tecnico not found"));
        t.setNombre(dto.getNombre());
        t.setTelefono(dto.getTelefono());
        t.setHorario(dto.getHorario());
        if (dto.getIdTaller() != null) {
            Taller ta = tallerRepo.findById(dto.getIdTaller()).orElseThrow(() -> new RuntimeException("Taller not found"));
            t.setTaller(ta);
        } else {
            t.setTaller(null);
        }
        return toDto(repo.save(t));
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
