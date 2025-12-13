package com.backendHospital.hospital_Apirest.controller;

import com.backendHospital.hospital_Apirest.dto.TecnicoRequestDto;
import com.backendHospital.hospital_Apirest.dto.TecnicoResponseDto;
import com.backendHospital.hospital_Apirest.service.TecnicoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tecnicos")
@RequiredArgsConstructor
public class TecnicoController {

    private final TecnicoService service;

    @GetMapping
    public ResponseEntity<List<TecnicoResponseDto>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TecnicoResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<TecnicoResponseDto> create(@RequestBody TecnicoRequestDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TecnicoResponseDto> update(@PathVariable Long id, @RequestBody TecnicoRequestDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
