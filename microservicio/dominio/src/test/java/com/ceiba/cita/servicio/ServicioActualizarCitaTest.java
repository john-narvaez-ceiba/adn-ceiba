package com.ceiba.cita.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.cita.modelo.entidad.Cita;
import com.ceiba.cita.puerto.repositorio.RepositorioCita;
import com.ceiba.cita.servicio.testdatabuilder.CitaTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

public class ServicioActualizarCitaTest {

    @Test
    public void actualizarCitaTest() {
        // arrange
        Cita cita = new CitaTestDataBuilder().id(null).build();
        RepositorioCita repositorioCita = Mockito.mock(RepositorioCita.class);
        Mockito.when(repositorioCita.existe(Mockito.anyLong(), Mockito.any())).thenReturn(true);
        ServicioActualizarCita servicioActualizarCita  = new ServicioActualizarCita(repositorioCita);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarCita.ejecutar(cita), ExcepcionDuplicidad.class,"El paciente ya tiene una cita asignada para esa fecha");
    }
}
