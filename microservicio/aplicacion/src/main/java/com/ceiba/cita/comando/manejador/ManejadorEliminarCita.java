package com.ceiba.cita.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.paciente.servicio.ServicioEliminarPaciente;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ManejadorEliminarCita implements ManejadorComando<Long> {

    private final ServicioEliminarPaciente servicioEliminarPaciente;

    public ManejadorEliminarCita(ServicioEliminarPaciente servicioEliminarPaciente) {
        this.servicioEliminarPaciente = servicioEliminarPaciente;
    }


    public void ejecutar(Long idCita) throws IOException {
        this.servicioEliminarPaciente.ejecutar(idCita);
    }
}
