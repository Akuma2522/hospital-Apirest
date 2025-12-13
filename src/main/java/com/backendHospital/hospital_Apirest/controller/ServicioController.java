package com.backendHospital.hospital_Apirest.controller;

import com.backendHospital.hospital_Apirest.dto.ServicioRequestDto;
import com.backendHospital.hospital_Apirest.dto.ServicioResponseDto;
import com.backendHospital.hospital_Apirest.service.ServicioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/servicios")
@RequiredArgsConstructor
public class ServicioController {

    private final ServicioService service;

    @GetMapping
    public ResponseEntity<List<ServicioResponseDto>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServicioResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }


    @GetMapping("/buscar/{id}")
    public ResponseEntity<List<ServicioResponseDto>> getByUnidad(@PathVariable Long id) {
        return ResponseEntity.ok(service.findByUnidad(id));
    }

    @PostMapping
    public ResponseEntity<ServicioResponseDto> create(@RequestBody ServicioRequestDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServicioResponseDto> update(@PathVariable Long id, @RequestBody ServicioRequestDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
