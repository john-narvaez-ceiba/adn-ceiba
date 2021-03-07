package com.ceiba.paciente.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.paciente.servicio.ServicioEliminarPaciente;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
public class ManejadorEliminarPaciente implements ManejadorComando<Long> {

    private final ServicioEliminarPaciente servicioEliminarPaciente;

    public ManejadorEliminarPaciente(ServicioEliminarPaciente servicioEliminarPaciente) {
        this.servicioEliminarPaciente = servicioEliminarPaciente;
    }

    public void ejecutar(Long idPaciente) throws IOException {
        this.servicioEliminarPaciente.ejecutar(idPaciente);
    }
}
