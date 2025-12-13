package com.backendHospital.hospital_Apirest.controller;

import com.backendHospital.hospital_Apirest.dto.OrganoDesconcentradoRequestDto;
import com.backendHospital.hospital_Apirest.dto.OrganoDesconcentradoResponseDto;
import com.backendHospital.hospital_Apirest.service.OrganoDesconcentradoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/organos")
@RequiredArgsConstructor
public class OrganoDesconcentradoController {

    private final OrganoDesconcentradoService service;

    @GetMapping
    public ResponseEntity<List<OrganoDesconcentradoResponseDto>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrganoDesconcentradoResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<OrganoDesconcentradoResponseDto> create(@RequestBody OrganoDesconcentradoRequestDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrganoDesconcentradoResponseDto> update(@PathVariable Long id, @RequestBody OrganoDesconcentradoRequestDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}