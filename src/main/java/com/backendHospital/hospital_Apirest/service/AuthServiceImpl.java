package com.backendHospital.hospital_Apirest.service;

import com.backendHospital.hospital_Apirest.dto.LoginRequestDto;
import com.backendHospital.hospital_Apirest.dto.LoginResponseDto;
import com.backendHospital.hospital_Apirest.model.Usuario;
import com.backendHospital.hospital_Apirest.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    @Override
    public LoginResponseDto login(LoginRequestDto dto) {

        Usuario usuario = usuarioRepository.findByUsername(dto.getUsername())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        if (!passwordEncoder.matches(dto.getPassword(), usuario.getPassword())) {
            throw new RuntimeException("Contraseña incorrecta");
        }

        return new LoginResponseDto(
                usuario.getId(),
                usuario.getUsername(),
                usuario.getRol()
        );
    }

}
