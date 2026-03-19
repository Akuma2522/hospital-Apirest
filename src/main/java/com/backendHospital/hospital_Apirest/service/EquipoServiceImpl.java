package com.backendHospital.hospital_Apirest.service;

import com.backendHospital.hospital_Apirest.dto.EquipoDetalleDto;
import com.backendHospital.hospital_Apirest.dto.EquipoRequestDto;
import com.backendHospital.hospital_Apirest.dto.EquipoResponseDto;
import com.backendHospital.hospital_Apirest.dto.EquipoUpdateDto;
import com.backendHospital.hospital_Apirest.enums.EstadoEquipo;
import com.backendHospital.hospital_Apirest.exceptions.ResourceNotFoundException;
import com.backendHospital.hospital_Apirest.model.Equipo;
import com.backendHospital.hospital_Apirest.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EquipoServiceImpl implements EquipoService {

    private final EquipoRepository repo;
    private final MarcaRepository marcaRepo;
    private final ModeloRepository modeloRepo;
    private final TallerRepository tallerRepo;
    private final TecnicoRepository tecnicoRepo;
    private final ProveedorRepository proveedorRepo;
    private final ServicioRepository servicioRepo;
    private final EquipoRepository equipoRepo;

    private EquipoDetalleDto toDto(Equipo e) {
        return EquipoDetalleDto.builder()
                .id(e.getId())
                .codigoPatrimonial(e.getCodigoPatrimonial())
                .denominacionEspecifica(e.getDenominacionEspecifica())
                .marca(e.getMarca() != null ? e.getMarca().getNombre() : null)
                .modelo(e.getModelo() != null ? e.getModelo().getNombre() : null)
                .serie(e.getSerie())
                .estado(e.getEstado().getDescripcion())
                .taller(e.getTaller() != null ? e.getTaller().getNombre() : null)
                .servicio(e.getServicio() != null ? e.getServicio().getNombre() : null)
                .hospital(e.getServicio().getUnidad() != null ? e.getServicio().getUnidad().getNombre() : null)
                .frecuenciaMantenimiento(e.getFrecuenciaMantenimiento())
                .ultimoMantenimiento(e.getUltimoMantenimiento())
                .proximoMantenimiento(e.getProximoMantenimiento())
                .tipoMantenimiento(e.getTipoMantenimiento())
                .build();
    }

    private EquipoResponseDto toDtoCreate(Equipo e) {
        return EquipoResponseDto.builder()
                .id(e.getId())
                .codigoPatrimonial(e.getCodigoPatrimonial())
                .denominacionGeneral(e.getDenominacionGeneral())
                .denominacionEspecifica(e.getDenominacionEspecifica())
                .marca(e.getMarca() != null ? e.getMarca().getNombre() : null)
                .modelo(e.getModelo() != null ? e.getModelo().getNombre() : null)
                .serie(e.getSerie())
                .tipoEquipamiento(e.getTipoEquipamiento())
                .criticidad(e.getCriticidad())
                .estado(e.getEstado().getDescripcion())
                .modalidadEjecucion(e.getModalidadEjecucion())
                .idTaller(e.getTaller() != null ? e.getTaller().getId() : null)
                .idTecnico(e.getTecnico().getId())
                .anioAdquisicion(e.getAnioAdquisicion())
                .vidaUtilYears(e.getVidaUtilYears())
                .idProveedor(e.getProveedor().getId())
                .fechaRecepcion(e.getFechaRecepcion())
                .idHospital(e.getServicio().getUnidad().getId())
                .frecuenciaMantenimiento(e.getFrecuenciaMantenimiento())
                .ultimoMantenimiento(e.getUltimoMantenimiento())
                .proximoMantenimiento(e.getProximoMantenimiento())
                .tipoMantenimiento(e.getTipoMantenimiento())
                .idServicio(e.getServicio() != null ? e.getServicio().getId() : null)
                .equipoPrincipalId(e.getEquipoPrincipal().getId())
                .build();
    }

    @Override
    public List<EquipoDetalleDto> findAll() {
        return repo.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public EquipoDetalleDto findById(Long id) {
        Equipo e = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Equipo con ID " + id + " no encontrado"));
        return toDto(e);
    }

    @Override
    public EquipoResponseDto create(EquipoRequestDto dto) {

        // VALIDACIÓN MANUAL: evitar duplicados
        if (repo.existsByCodigoPatrimonial(dto.getCodigoPatrimonial())) {
            throw new IllegalArgumentException(
                    "El código patrimonial ya existe: " + dto.getCodigoPatrimonial()
            );
        }

        Equipo e = Equipo.builder()
                .codigoPatrimonial(dto.getCodigoPatrimonial())
                .denominacionGeneral(dto.getDenominacionGeneral())
                .denominacionEspecifica(dto.getDenominacionEspecifica())
                .serie(dto.getSerie())
                .tipoEquipamiento(dto.getTipoEquipamiento())
                .criticidad(dto.getCriticidad())
                .estado(dto.getEstado())
                .modalidadEjecucion(dto.getModalidadEjecucion())
                .anioAdquisicion(dto.getAnioAdquisicion())
                .vidaUtilYears(dto.getVidaUtilYears())
                .fechaRecepcion(dto.getFechaRecepcion())
                .frecuenciaMantenimiento(dto.getFrecuenciaMantenimiento())
                .ultimoMantenimiento(dto.getUltimoMantenimiento())
                .proximoMantenimiento(dto.getProximoMantenimiento())
                .tipoMantenimiento(dto.getTipoMantenimiento())
                .build();

        if (dto.getIdMarca() != null) {
            e.setMarca(marcaRepo.findById(dto.getIdMarca())
                    .orElseThrow(() -> new RuntimeException("Marca not found")));
        }
        if (dto.getIdModelo() != null) {
            e.setModelo(modeloRepo.findById(dto.getIdModelo())
                    .orElseThrow(() -> new RuntimeException("Modelo not found")));
        }
        if (dto.getIdTaller() != null) {
            e.setTaller(tallerRepo.findById(dto.getIdTaller())
                    .orElseThrow(() -> new RuntimeException("Taller not found")));
        }
        if (dto.getIdTecnico() != null) {
            e.setTecnico(tecnicoRepo.findById(dto.getIdTecnico())
                    .orElseThrow(() -> new RuntimeException("Tecnico not found")));
        }
        if (dto.getIdProveedor() != null) {
            e.setProveedor(proveedorRepo.findById(dto.getIdProveedor())
                    .orElseThrow(() -> new RuntimeException("Proveedor not found")));
        }
        if (dto.getIdServicio() != null) {
            e.setServicio(servicioRepo.findById(dto.getIdServicio())
                    .orElseThrow(() -> new RuntimeException("Servicio not found")));
        }

        if (dto.getEquipoPrincipalId() != null) {
            e.setEquipoPrincipal(equipoRepo.findById(dto.getEquipoPrincipalId())
                    .orElseThrow(() -> new RuntimeException("Equipo principal not found")));
        }

        return toDtoCreate(repo.save(e));
    }


    @Override
    public EquipoDetalleDto update(Long id, EquipoUpdateDto dto) {

        Equipo e = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Equipo not found"));

        e.setEstado(EstadoEquipo.valueOf(dto.getEstado()));
        e.setUltimoMantenimiento(dto.getUltimoMantenimiento());
        e.setTipoMantenimiento(dto.getTipoMantenimiento());
        if (dto.getIdTaller() != null) e.setTaller(tallerRepo.findById(dto.getIdTaller()).orElseThrow());
        if (dto.getIdServicio() != null) e.setServicio(servicioRepo.findById(dto.getIdServicio()).orElseThrow());
        return toDto(repo.save(e));
    }


    @Override
    public void delete(Long id) {
        if (!repo.existsById(id))
            throw new ResourceNotFoundException("No se encontró el equipo con ID " + id);
        repo.deleteById(id);
    }

    @Override
    public EquipoDetalleDto buscarPorCodigoPatrimonial(String codigo) {

        Equipo equipo = repo.findByCodigoPatrimonial(codigo)
                .orElseThrow(() ->
                        new ResourceNotFoundException("No se encontró el equipo con código: " + codigo)
                );
        return toDto(equipo);



    }


}
