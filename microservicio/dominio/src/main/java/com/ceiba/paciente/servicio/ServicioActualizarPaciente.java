package com.ceiba.paciente.servicio;
import com.ceiba.paciente.modelo.entidad.Paciente;
import com.ceiba.paciente.puerto.repositorio.RepositorioPaciente;

import java.io.IOException;

public class ServicioActualizarPaciente {

    private final RepositorioPaciente repositorioPaciente;
    private static final String ERROR_ACTUALIZAR_PACIENTE = "Error al actualizar paciente";

    public ServicioActualizarPaciente(RepositorioPaciente repositorioUsuario) {
        this.repositorioPaciente = repositorioUsuario;
    }

    public void ejecutar(Paciente paciente) throws IOException {

        if(paciente.getId() == null) {
            throw new IOException(ERROR_ACTUALIZAR_PACIENTE);
        }
        this.repositorioPaciente.actualizar(paciente);
    }
}
