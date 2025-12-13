package com.backendHospital.hospital_Apirest.controller;

import com.backendHospital.hospital_Apirest.dto.EquipoDetalleDto;
import com.backendHospital.hospital_Apirest.dto.EquipoRequestDto;
import com.backendHospital.hospital_Apirest.dto.EquipoResponseDto;
import com.backendHospital.hospital_Apirest.dto.EquipoUpdateDto;
import com.backendHospital.hospital_Apirest.service.EquipoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/equipos")
@RequiredArgsConstructor
public class EquipoController {

    private final EquipoService service;

    @GetMapping
    public ResponseEntity<List<EquipoDetalleDto>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EquipoDetalleDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<EquipoResponseDto> create(@RequestBody EquipoRequestDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @PatchMapping ("/{id}")
    public ResponseEntity<EquipoDetalleDto> update(@PathVariable Long id, @RequestBody EquipoUpdateDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/buscar/{codigo}")
    public ResponseEntity<EquipoDetalleDto> buscar(@PathVariable String codigo) {
        return ResponseEntity.ok(service.buscarPorCodigoPatrimonial(codigo));
    }
}
