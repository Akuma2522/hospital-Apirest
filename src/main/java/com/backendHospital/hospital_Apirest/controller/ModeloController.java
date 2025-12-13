package com.backendHospital.hospital_Apirest.controller;

import com.backendHospital.hospital_Apirest.dto.ModeloRequestDto;
import com.backendHospital.hospital_Apirest.dto.ModeloResponseDto;
import com.backendHospital.hospital_Apirest.service.ModeloService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/modelos")
@RequiredArgsConstructor
public class ModeloController {

    private final ModeloService service;

    @GetMapping
    public ResponseEntity<List<ModeloResponseDto>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModeloResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<ModeloResponseDto> create(@RequestBody ModeloRequestDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ModeloResponseDto> update(@PathVariable Long id, @RequestBody ModeloRequestDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
