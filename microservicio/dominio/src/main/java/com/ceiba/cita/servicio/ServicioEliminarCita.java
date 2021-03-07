package com.ceiba.cita.servicio;

import com.ceiba.cita.puerto.repositorio.RepositorioCita;

import java.io.IOException;

public class ServicioEliminarCita {

    private final RepositorioCita repositorioCita;
    private static final String ERROR_ELIMINAR_CITA = "Error al eliminar cita";

    public ServicioEliminarCita(RepositorioCita repositorioCita) {
        this.repositorioCita = repositorioCita;
    }

    public void ejecutar(Long id) throws IOException {

        if(id == null) {
            throw new IOException(ERROR_ELIMINAR_CITA);
        }
        this.repositorioCita.eliminar(id);
    }
}
