package com.backendHospital.hospital_Apirest.service;

import com.backendHospital.hospital_Apirest.model.Equipo;
import com.backendHospital.hospital_Apirest.repository.EquipoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@EnableScheduling
@Component
public class MantenimientoScheduler {

    @Autowired
    private EquipoRepository repo;

    @Autowired
    private NotificacionService notificacionService;
    @Transactional
    @Scheduled(cron = "0 15 18 * * *", zone = "America/Lima") // todos los días 8 AM
    public void actualizarMantenimientos() {

        LocalDate hoy = LocalDate.now();

        // 🔥 ya no usamos notificado
        List<Equipo> equipos =
                repo.findByProximoMantenimientoLessThanEqual(hoy);

        for (Equipo e : equipos) {

            // 🔔 obtener usuario del técnico
            var usuario = e.getTecnico().getUsuario();

            // 🔔 enviar a TODOS los dispositivos del usuario
            if (usuario.getDispositivos() != null) {
                usuario.getDispositivos().forEach(d ->
                        notificacionService.enviar(
                                d.getToken(),
                                "Aviso",
                                "Al equipo " + e.getCodigoPatrimonial() + " "+ e.getDenominacionGeneral() + " le corresponde mantenimiento hoy"
                        )
                );
            }

            // 🔁 recalcular próxima fecha en MESES
            LocalDate proximo = e.getProximoMantenimiento();

            while (!proximo.isAfter(hoy)) {
                proximo = proximo.plusMonths(e.getFrecuenciaMantenimiento());
            }

            e.setProximoMantenimiento(proximo);

            repo.save(e);
        }
    }
}