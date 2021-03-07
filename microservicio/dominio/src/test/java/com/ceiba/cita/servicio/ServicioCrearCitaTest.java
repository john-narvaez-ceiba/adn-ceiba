package com.ceiba.cita.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.cita.modelo.entidad.Cita;
import com.ceiba.cita.puerto.repositorio.RepositorioCita;
import com.ceiba.cita.servicio.testdatabuilder.CitaTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioCrearCitaTest {

    @Test
    public void validarExistenciaPreviaTest() {
        // arrange
        Cita cita = new CitaTestDataBuilder().build();
        RepositorioCita repositorioCita = Mockito.mock(RepositorioCita.class);
        Mockito.when(repositorioCita.existe(Mockito.anyLong(), Mockito.any())).thenReturn(true);
        ServicioCrearCita servicioCrearCita = new ServicioCrearCita(repositorioCita);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearCita.ejecutar(cita), ExcepcionDuplicidad.class,"El paciente ya tiene una cita asignada para esa fecha");
    }
}
