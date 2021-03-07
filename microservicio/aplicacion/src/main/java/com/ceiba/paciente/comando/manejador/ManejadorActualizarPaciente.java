package com.ceiba.paciente.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.paciente.modelo.entidad.Paciente;
import com.ceiba.paciente.servicio.ServicioActualizarPaciente;
import org.springframework.stereotype.Component;

import com.ceiba.paciente.comando.ComandoPaciente;
import com.ceiba.paciente.comando.fabrica.FabricaPaciente;

import java.io.IOException;

@Component
public class ManejadorActualizarPaciente implements ManejadorComando<ComandoPaciente> {

    private final FabricaPaciente fabricaPaciente;
    private final ServicioActualizarPaciente servicioActualizarPaciente;

    public ManejadorActualizarPaciente(FabricaPaciente fabricaPaciente, ServicioActualizarPaciente servicioActualizarPaciente) {
        this.fabricaPaciente = fabricaPaciente;
        this.servicioActualizarPaciente = servicioActualizarPaciente;
    }

    public void ejecutar(ComandoPaciente comandoPaciente) throws IOException {
        Paciente paciente = this.fabricaPaciente.crear(comandoPaciente);
        this.servicioActualizarPaciente.ejecutar(paciente);
    }
}
