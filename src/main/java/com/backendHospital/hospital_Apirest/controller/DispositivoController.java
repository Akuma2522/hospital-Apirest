package com.backendHospital.hospital_Apirest.controller;

import com.backendHospital.hospital_Apirest.model.Dispositivo;
import com.backendHospital.hospital_Apirest.model.Usuario;
import com.backendHospital.hospital_Apirest.repository.DispositivoRepository;
import com.backendHospital.hospital_Apirest.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/dispositivo")
@RequiredArgsConstructor
public class DispositivoController {

    private final UsuarioRepository usuarioRepo;
    private final DispositivoRepository dispositivoRepo;

    @PostMapping("/registrar")
    public String registrarToken(@RequestBody Map<String, String> body) {

        Long idUsuario = Long.parseLong(body.get("idUsuario"));
        String token = body.get("token");

        Usuario usuario = usuarioRepo.findById(idUsuario)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        // 🔍 verificar si ya existe ese token
        Dispositivo existente = dispositivoRepo.findByToken(token);

        if (existente == null) {
            Dispositivo d = new Dispositivo();
            d.setUsuario(usuario);
            d.setToken(token);
            dispositivoRepo.save(d);
        }

        return "Token registrado";
    }
}