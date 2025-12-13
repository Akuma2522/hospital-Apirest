package com.backendHospital.hospital_Apirest.controller;

import com.backendHospital.hospital_Apirest.dto.LoginRequestDto;
import com.backendHospital.hospital_Apirest.dto.LoginResponseDto;
import com.backendHospital.hospital_Apirest.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public LoginResponseDto login(@RequestBody LoginRequestDto dto) {
        return authService.login(dto);
    }
}
