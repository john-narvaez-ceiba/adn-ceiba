package com.ceiba.paciente.consulta;

import java.util.List;

import com.ceiba.paciente.puerto.dao.DaoPaciente;
import org.springframework.stereotype.Component;
import com.ceiba.paciente.modelo.dto.DtoPaciente;

@Component
public class ManejadorListarPaciente {

    private final DaoPaciente daoPaciente;

    public ManejadorListarPaciente(DaoPaciente daoPaciente){
        this.daoPaciente = daoPaciente;
    }

    public List<DtoPaciente> ejecutar(){ return this.daoPaciente.listar(); }
}
