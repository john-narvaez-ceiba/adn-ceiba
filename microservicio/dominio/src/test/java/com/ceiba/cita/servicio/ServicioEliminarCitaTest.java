package com.ceiba.cita.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.cita.modelo.entidad.Cita;
import com.ceiba.cita.puerto.repositorio.RepositorioCita;
import com.ceiba.cita.servicio.testdatabuilder.CitaTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

public class ServicioEliminarCitaTest {

    @Test
    public void eliminarCitaTest() {
        // arrange
        Cita cita = new CitaTestDataBuilder().id(null).build();
        RepositorioCita repositorioCita = Mockito.mock(RepositorioCita.class);
        ServicioEliminarCita servicioEliminarCita  = new ServicioEliminarCita(repositorioCita);
        // act - assert
        Assertions.assertThrows(Exception.class, () -> servicioEliminarCita.ejecutar(cita.getId()));
    }
}
