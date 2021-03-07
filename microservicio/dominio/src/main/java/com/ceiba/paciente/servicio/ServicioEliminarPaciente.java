package com.ceiba.paciente.servicio;

import com.ceiba.paciente.puerto.repositorio.RepositorioPaciente;

import java.io.IOException;

public class ServicioEliminarPaciente {

    private final RepositorioPaciente repositorioPaciente;
    private static final String ERROR_ELIMINAR_PACIENTE = "Error al eliminar paciente";

    public ServicioEliminarPaciente(RepositorioPaciente repositorioPaciente) {
        this.repositorioPaciente = repositorioPaciente;
    }

    public void ejecutar(Long id) throws IOException {

        if(id == null) {
            throw new IOException(ERROR_ELIMINAR_PACIENTE);
        }
        this.repositorioPaciente.eliminar(id);
    }
}
