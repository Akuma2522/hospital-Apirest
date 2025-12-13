package com.backendHospital.hospital_Apirest.controller;

import com.backendHospital.hospital_Apirest.dto.ProveedorRequestDto;
import com.backendHospital.hospital_Apirest.dto.ProveedorResponseDto;
import com.backendHospital.hospital_Apirest.service.ProveedorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/proveedores")
@RequiredArgsConstructor
public class ProveedorController {

    private final ProveedorService service;

    @GetMapping
    public ResponseEntity<List<ProveedorResponseDto>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProveedorResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<ProveedorResponseDto> create(@RequestBody ProveedorRequestDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProveedorResponseDto> update(@PathVariable Long id, @RequestBody ProveedorRequestDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
