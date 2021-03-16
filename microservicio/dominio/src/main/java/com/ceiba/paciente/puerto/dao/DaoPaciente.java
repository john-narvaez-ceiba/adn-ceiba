package com.ceiba.paciente.puerto.dao;

import com.ceiba.paciente.modelo.dto.DtoPaciente;

import java.util.List;

public interface DaoPaciente {

    /**
     * Permite listar pacientes
     * @return los pacientes
     */
    List<DtoPaciente> listar();

    List<DtoPaciente> listarId(Long id);
}
