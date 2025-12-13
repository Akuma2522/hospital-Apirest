package com.backendHospital.hospital_Apirest.controller;

import com.backendHospital.hospital_Apirest.dto.EstadoDto;
import com.backendHospital.hospital_Apirest.service.EstadoService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estados")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class EstadoController {

    private final EstadoService estadoService;

    @GetMapping
    public List<EstadoDto> listar() {
        return estadoService.listarEstados();
    }
}
