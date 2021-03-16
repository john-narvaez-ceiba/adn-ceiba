package com.ceiba.cita.puerto.repositorio;

import com.ceiba.cita.modelo.entidad.Cita;
import java.time.LocalDate;

public interface RepositorioCita {

    /**
     * Permite crear una cita
     * @param cita
     * @return el id generado
     */
    Long crear(Cita cita);

    /**
     * Permite actualizar una cita
     * @param cita
     */
    void actualizar(Cita cita);

    /**
     * Permite eliminar un cita
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si un paciente tiene una cita ese mismo dia
     * @param idPaciente, fechaCita
     * @return si existe o no
     */
    boolean existe(Long idPaciente, LocalDate fechaCita);

    /**
     * Permite obtener el número de cédula del paciente
     * @param idPaciente
     * @return número de cédula
     */

    Integer obtenerCedula(Long idPaciente);
}
