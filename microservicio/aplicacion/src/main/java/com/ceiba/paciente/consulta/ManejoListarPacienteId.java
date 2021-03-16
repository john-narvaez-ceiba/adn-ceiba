package com.ceiba.paciente.consulta;

import com.ceiba.paciente.modelo.dto.DtoPaciente;
import com.ceiba.paciente.puerto.dao.DaoPaciente;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejoListarPacienteId {

    private final DaoPaciente daoPaciente;

    public ManejoListarPacienteId(DaoPaciente daoPaciente) {
        this.daoPaciente = daoPaciente;
    }

    public List<DtoPaciente> ejecutar(Long id){ return this.daoPaciente.listarId(id); }
}
