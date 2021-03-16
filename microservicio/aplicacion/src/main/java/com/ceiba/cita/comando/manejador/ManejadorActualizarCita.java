package com.ceiba.cita.comando.manejador;

import com.ceiba.cita.comando.ComandoCita;
import com.ceiba.cita.comando.fabrica.FabricaCita;
import com.ceiba.cita.modelo.entidad.Cita;
import com.ceiba.cita.servicio.ServicioActualizarCita;
import com.ceiba.manejador.ManejadorComando;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ManejadorActualizarCita implements ManejadorComando<ComandoCita> {

    private final FabricaCita fabricaCita;
    private final ServicioActualizarCita servicioActualizarCita;

    public ManejadorActualizarCita(FabricaCita fabricaCita, ServicioActualizarCita servicioActualizarCita) {
        this.fabricaCita = fabricaCita;
        this.servicioActualizarCita = servicioActualizarCita;
    }

    public void ejecutar(ComandoCita comandoCita) throws IOException {
        Cita cita = this.fabricaCita.crear(comandoCita);
        this.servicioActualizarCita.ejecutar(cita);
    }
}
