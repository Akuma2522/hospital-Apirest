package com.backendHospital.hospital_Apirest.exceptions;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // ❌ 1. Entidad no encontrada
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> handleNotFound(EntityNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                error("NOT_FOUND", ex.getMessage())
        );
    }

    // ❌ 2. Errores de integridad (FK, unique, null, etc.)
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<?> handleIntegrityViolation(DataIntegrityViolationException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                error("DATA_INTEGRITY_ERROR", "Violación de integridad: " + ex.getMostSpecificCause().getMessage())
        );
    }

    // ❌ 3. Errores de validación de campos
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationErrors(MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(err -> {
            errors.put(err.getField(), err.getDefaultMessage());
        });

        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("error", "VALIDATION_ERROR");
        body.put("details", errors);

        return ResponseEntity.badRequest().body(body);
    }

    // ❌ 4. Errores generales
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGeneral(Exception ex) {
        ex.printStackTrace(); // opcional para logs
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                error("INTERNAL_ERROR", "Ha ocurrido un error inesperado.")
        );
    }

    // 📌 Método utilitario para respuesta uniforme
    private Map<String, Object> error(String type, String message) {
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("error", type);
        body.put("message", message);
        return body;
    }
}
