package com.ceiba.cita.comando.fabrica;

import com.ceiba.cita.comando.ComandoCita;
import com.ceiba.cita.modelo.entidad.Cita;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class FabricaCita {

    public Cita crear(ComandoCita comandoCita) throws IOException {
        return new Cita(
                comandoCita.getId(),
                comandoCita.getIdPaciente(),
                comandoCita.getValorOriginal(),
                comandoCita.getValorDescuento(),
                comandoCita.getDescuento(),
                comandoCita.getEfectivo(),
                comandoCita.getFechaCita()
        );
    }
}
