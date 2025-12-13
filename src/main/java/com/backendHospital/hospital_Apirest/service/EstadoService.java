package com.backendHospital.hospital_Apirest.service;

import com.backendHospital.hospital_Apirest.dto.EstadoDto;
import com.backendHospital.hospital_Apirest.enums.EstadoEquipo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays;

@Service
public class EstadoService {

    public List<EstadoDto> listarEstados() {

        return Arrays.stream(EstadoEquipo.values())
                .map(e -> new EstadoDto(
                        e.name(),          // "OPERATIVO_BUENO"
                        e.getDescripcion() // "Operativo Bueno"
                ))
                .collect(Collectors.toList());
    }
}
