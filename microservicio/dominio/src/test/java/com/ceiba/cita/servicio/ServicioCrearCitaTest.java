package com.ceiba.cita.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.cita.modelo.entidad.Cita;
import com.ceiba.cita.puerto.repositorio.RepositorioCita;
import com.ceiba.cita.servicio.testdatabuilder.CitaTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionCita;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

import java.io.IOException;

public class ServicioCrearCitaTest {

    @Test
    public void validarExistenciaPreviaTest() throws IOException {
        // arrange
        Cita cita = new CitaTestDataBuilder().build();
        RepositorioCita repositorioCita = Mockito.mock(RepositorioCita.class);
        Mockito.when(repositorioCita.existe(Mockito.anyLong(), Mockito.any())).thenReturn(true);
        ServicioCrearCita servicioCrearCita = new ServicioCrearCita(repositorioCita);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearCita.ejecutar(cita), ExcepcionDuplicidad.class,"El paciente ya tiene una cita asignada para esa fecha");
    }

    @Test
    public void validarPicoCedula() throws IOException {
        // arrange
        Cita cita = new CitaTestDataBuilder().build();
        RepositorioCita repositorioCita = Mockito.mock(RepositorioCita.class);
        Mockito.when(repositorioCita.obtenerCedula(Mockito.anyLong())).thenReturn(1082215681);
        ServicioCrearCita servicioCrearCita = new ServicioCrearCita(repositorioCita);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearCita.ejecutar(cita), ExcepcionCita.class,"El paciente no tiene pico y cédula");
    }

    @Test
    public void validarPagoEfectivo() throws IOException {
        // arrange
        Cita cita = new CitaTestDataBuilder().build();
        RepositorioCita repositorioCita = Mockito.mock(RepositorioCita.class);
        // act - assert
        Assertions.assertThrows(Exception.class, () -> cita.validarPagoEfectivo(cita.getValorOriginal(), null));
    }
}
