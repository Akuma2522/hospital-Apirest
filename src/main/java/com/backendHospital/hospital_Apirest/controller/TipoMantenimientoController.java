package com.backendHospital.hospital_Apirest.controller;

import com.backendHospital.hospital_Apirest.dto.EstadoDto;
import com.backendHospital.hospital_Apirest.enums.TipoMantenimiento;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/tipomantenimiento")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class TipoMantenimientoController {
    @GetMapping
    public TipoMantenimiento[] listar() {
        return TipoMantenimiento.values();
    }
}
