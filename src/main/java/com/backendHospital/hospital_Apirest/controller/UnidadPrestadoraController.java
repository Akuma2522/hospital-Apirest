package com.backendHospital.hospital_Apirest.controller;

import com.backendHospital.hospital_Apirest.dto.UnidadPrestadoraRequestDto;
import com.backendHospital.hospital_Apirest.dto.UnidadPrestadoraResponseDto;
import com.backendHospital.hospital_Apirest.service.UnidadPrestadoraService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/unidades")
@RequiredArgsConstructor
public class UnidadPrestadoraController {

    private final UnidadPrestadoraService service;

    @GetMapping
    public ResponseEntity<List<UnidadPrestadoraResponseDto>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UnidadPrestadoraResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<UnidadPrestadoraResponseDto> create(@RequestBody UnidadPrestadoraRequestDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UnidadPrestadoraResponseDto> update(@PathVariable Long id, @RequestBody UnidadPrestadoraRequestDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}