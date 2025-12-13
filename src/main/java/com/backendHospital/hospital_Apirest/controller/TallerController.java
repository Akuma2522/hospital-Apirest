package com.backendHospital.hospital_Apirest.controller;

import com.backendHospital.hospital_Apirest.dto.TallerRequestDto;
import com.backendHospital.hospital_Apirest.dto.TallerResponseDto;
import com.backendHospital.hospital_Apirest.service.TallerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/talleres")
@RequiredArgsConstructor
public class TallerController {

    private final TallerService service;

    @GetMapping
    public ResponseEntity<List<TallerResponseDto>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TallerResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<TallerResponseDto> create(@RequestBody TallerRequestDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TallerResponseDto> update(@PathVariable Long id, @RequestBody TallerRequestDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
