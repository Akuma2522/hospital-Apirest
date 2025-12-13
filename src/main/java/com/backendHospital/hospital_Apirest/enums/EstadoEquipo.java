package com.backendHospital.hospital_Apirest.enums;

public enum EstadoEquipo {

    OPERATIVO_BUENO("Operativo Bueno"),
    OPERATIVO_REGULAR("Operativo Regular"),
    INOPERATIVO_POR_REPARAR("Inoperativo por Reparar"),
    INOPERATIVO_PARA_BAJA("Inoperativo para Baja");

    private final String descripcion;

    EstadoEquipo(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
