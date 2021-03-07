package com.ceiba.paciente.servicio;

import com.ceiba.paciente.modelo.entidad.Paciente;
import com.ceiba.paciente.puerto.repositorio.RepositorioPaciente;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;


public class ServicioCrearPaciente {

    private static final String EL_PACIENTE_YA_EXISTE_EN_EL_SISTEMA = "El paciente ya existe en el sistema";

    private final RepositorioPaciente repositorioPaciente;

    public ServicioCrearPaciente(RepositorioPaciente repositorioUsuario) {
        this.repositorioPaciente = repositorioUsuario;
    }

    public Long ejecutar(Paciente paciente) {
        validarExistenciaPrevia(paciente);
        return this.repositorioPaciente.crear(paciente);
    }

    private void validarExistenciaPrevia(Paciente paciente) {
        boolean existe = this.repositorioPaciente.existe(paciente.getNoCedula());
        if(existe) {
            throw new ExcepcionDuplicidad(EL_PACIENTE_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
