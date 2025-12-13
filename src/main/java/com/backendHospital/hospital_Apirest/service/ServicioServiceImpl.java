package com.backendHospital.hospital_Apirest.service;

import com.backendHospital.hospital_Apirest.dto.ServicioRequestDto;
import com.backendHospital.hospital_Apirest.dto.ServicioResponseDto;
import com.backendHospital.hospital_Apirest.model.Servicio;
import com.backendHospital.hospital_Apirest.model.UnidadPrestadora;
import com.backendHospital.hospital_Apirest.repository.ServicioRepository;
import com.backendHospital.hospital_Apirest.repository.UnidadPrestadoraRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ServicioServiceImpl implements ServicioService {

    private final ServicioRepository repo;
    private final UnidadPrestadoraRepository unidadRepo;

    private ServicioResponseDto toDto(Servicio s){
        return ServicioResponseDto.builder()
                .id(s.getId())
                .nombre(s.getNombre())
                .build();
    }

    @Override
    public List<ServicioResponseDto> findAll() {
        return repo.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public ServicioResponseDto findById(Long id) {
        Servicio s = repo.findById(id).orElseThrow(() -> new RuntimeException("Servicio not found"));
        return toDto(s);
    }
    @Override
    public List<ServicioResponseDto> findByUnidad(Long idUnidad) {
        return repo.findByUnidad_Id(idUnidad).stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public ServicioResponseDto create(ServicioRequestDto dto) {
        Servicio s = Servicio.builder()
                .nombre(dto.getNombre())
                .jefeServicio(dto.getJefeServicio())
                .celularJefe(dto.getCelularJefe())
                .build();
        if (dto.getIdUnidad() != null) {
            UnidadPrestadora u = unidadRepo.findById(dto.getIdUnidad()).orElseThrow(() -> new RuntimeException("Unidad not found"));
            s.setUnidad(u);
        }
        return toDto(repo.save(s));
    }

    @Override
    public ServicioResponseDto update(Long id, ServicioRequestDto dto) {
        Servicio s = repo.findById(id).orElseThrow(() -> new RuntimeException("Servicio not found"));
        s.setNombre(dto.getNombre());
        s.setJefeServicio(dto.getJefeServicio());
        s.setCelularJefe(dto.getCelularJefe());
        if (dto.getIdUnidad() != null) {
            UnidadPrestadora u = unidadRepo.findById(dto.getIdUnidad()).orElseThrow(() -> new RuntimeException("Unidad not found"));
            s.setUnidad(u);
        } else {
            s.setUnidad(null);
        }
        return toDto(repo.save(s));
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
