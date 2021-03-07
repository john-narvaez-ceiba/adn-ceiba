package com.ceiba.paciente.puerto.repositorio;

import com.ceiba.paciente.modelo.entidad.Paciente;

public interface RepositorioPaciente {
    /**
     * Permite crear un paciente
     * @param paciente
     * @return el id generado
     */
    Long crear(Paciente paciente);

    /**
     * Permite actualizar un paciente
     * @param paciente
     */
    void actualizar(Paciente paciente);

    /**
     * Permite eliminar un paciente
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si existe un paciente con un no. de cédula
     * @param noCedula
     * @return si existe o no
     */
    boolean existe(Integer noCedula);

}
