package com.ceiba.cita.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.cita.comando.ComandoCita;
import com.ceiba.cita.comando.fabrica.FabricaCita;
import com.ceiba.cita.modelo.entidad.Cita;
import com.ceiba.cita.servicio.ServicioCrearCita;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ManejadorCrearCita implements ManejadorComandoRespuesta<ComandoCita, ComandoRespuesta<Long>> {

    private final FabricaCita fabricaCita;
    private final ServicioCrearCita servicioCrearCita;


    public ManejadorCrearCita(FabricaCita fabricaCita, ServicioCrearCita servicioCrearCita) {
        this.fabricaCita = fabricaCita;
        this.servicioCrearCita = servicioCrearCita;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoCita comandoCita) throws IOException {
        Cita cita = this.fabricaCita.crear(comandoCita);
        return new ComandoRespuesta<>(this.servicioCrearCita.ejecutar(cita));
    }
}
