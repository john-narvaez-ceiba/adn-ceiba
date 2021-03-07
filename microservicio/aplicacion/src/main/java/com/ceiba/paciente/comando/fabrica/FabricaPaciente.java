package com.ceiba.paciente.comando.fabrica;

import com.ceiba.paciente.modelo.entidad.Paciente;
import org.springframework.stereotype.Component;
import com.ceiba.paciente.comando.ComandoPaciente;

@Component
public class FabricaPaciente {

    public Paciente crear(ComandoPaciente comandoPaciente) {
        return new Paciente(
                comandoPaciente.getId(),
                comandoPaciente.getNoCedula(),
                comandoPaciente.getNombre(),
                comandoPaciente.getApellido(),
                comandoPaciente.getDireccion(),
                comandoPaciente.getTelefono()
        );
    }
}
