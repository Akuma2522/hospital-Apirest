package com.backendHospital.hospital_Apirest.service;

import com.backendHospital.hospital_Apirest.dto.TallerRequestDto;
import com.backendHospital.hospital_Apirest.dto.TallerResponseDto;
import com.backendHospital.hospital_Apirest.model.Proveedor;
import com.backendHospital.hospital_Apirest.model.Taller;
import com.backendHospital.hospital_Apirest.repository.ProveedorRepository;
import com.backendHospital.hospital_Apirest.repository.TallerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TallerServiceImpl implements TallerService {

    private final TallerRepository repo;
    private final ProveedorRepository proveedorRepo;

    private TallerResponseDto toDto(Taller t){
        return TallerResponseDto.builder()
                .id(t.getId())
                .nombre(t.getNombre())
                .residente(t.getResidente())
                .telefonoResidente(t.getTelefonoResidente())
                .correo(t.getCorreo())
                .idProveedor(t.getProveedor() != null ? t.getProveedor().getId() : null)
                .build();
    }

    @Override
    public List<TallerResponseDto> findAll() {
        return repo.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public TallerResponseDto findById(Long id) {
        Taller t = repo.findById(id).orElseThrow(() -> new RuntimeException("Taller not found"));
        return toDto(t);
    }

    @Override
    public TallerResponseDto create(TallerRequestDto dto) {
        Taller t = Taller.builder()
                .nombre(dto.getNombre())
                .residente(dto.getResidente())
                .telefonoResidente(dto.getTelefonoResidente())
                .correo(dto.getCorreo())
                .build();
        if (dto.getIdProveedor() != null) {
            Proveedor p = proveedorRepo.findById(dto.getIdProveedor()).orElseThrow(() -> new RuntimeException("Proveedor not found"));
            t.setProveedor(p);
        }
        return toDto(repo.save(t));
    }

    @Override
    public TallerResponseDto update(Long id, TallerRequestDto dto) {
        Taller t = repo.findById(id).orElseThrow(() -> new RuntimeException("Taller not found"));
        t.setNombre(dto.getNombre());
        t.setResidente(dto.getResidente());
        t.setTelefonoResidente(dto.getTelefonoResidente());
        t.setCorreo(dto.getCorreo());
        if (dto.getIdProveedor() != null) {
            Proveedor p = proveedorRepo.findById(dto.getIdProveedor()).orElseThrow(() -> new RuntimeException("Proveedor not found"));
            t.setProveedor(p);
        } else {
            t.setProveedor(null);
        }
        return toDto(repo.save(t));
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
