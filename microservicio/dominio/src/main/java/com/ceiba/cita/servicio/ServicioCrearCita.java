package com.ceiba.cita.servicio;

import com.ceiba.cita.modelo.entidad.Cita;
import com.ceiba.cita.puerto.repositorio.RepositorioCita;
import com.ceiba.dominio.excepcion.ExcepcionCita;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

import java.time.LocalDate;

public class ServicioCrearCita {

    public static final int MOD_10 = 10;
    public static final int RANGO_VALOR_CITA_MENOR = 8000;
    public static final int RANGO_VALOR_CITA_MAYOR = 13000;
    private final RepositorioCita repositorioCita;

    private static final String EL_PACIENTE_YA_TIENE_CITA = "El paciente ya tiene una cita asignada para esa fecha";
    private static final String PACIENTE_PICO_CEDULA = "El paciente no tiene pico y cédula";
    private static final String VALOR_CITA  = "El valor de la cita no esta en el rango permitido";

    public ServicioCrearCita(RepositorioCita repositorioCita) {
        this.repositorioCita = repositorioCita;
    }

    public Long ejecutar(Cita cita) {

        validarExistenciaPrevia(cita.getIdPaciente(), cita.getFechaCita());
        validarPicoCedula(cita.getIdPaciente(), cita.getFechaCita());
        validarValorCita(cita.getValorOriginal());

        return this.repositorioCita.crear(cita);
    }

    public void validarExistenciaPrevia(Long idPaciente, LocalDate fechaCita) {
        boolean existe = this.repositorioCita.existe(idPaciente, fechaCita);

        if(existe) {
            throw new ExcepcionDuplicidad(EL_PACIENTE_YA_TIENE_CITA);
        }
    }

    public void validarPicoCedula(Long idPaciente, LocalDate fechaCita) {

        Integer noCedula = this.repositorioCita.obtenerCedula(idPaciente);
        Integer digitoCedula = noCedula% MOD_10;

        Integer dia = fechaCita.getDayOfMonth() < MOD_10 ? fechaCita.getDayOfMonth() : fechaCita.getDayOfMonth()% MOD_10;

        if(digitoCedula != dia) {
            throw new ExcepcionCita(PACIENTE_PICO_CEDULA);
        }
    }

    public void validarValorCita(Integer valorOriginal) {
        if(valorOriginal < RANGO_VALOR_CITA_MENOR || valorOriginal > RANGO_VALOR_CITA_MAYOR) {
            throw new ExcepcionCita(VALOR_CITA);
        }
    }
}
