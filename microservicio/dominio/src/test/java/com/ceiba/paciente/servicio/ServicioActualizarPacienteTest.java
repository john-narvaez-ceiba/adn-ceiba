package com.ceiba.paciente.servicio;

import com.ceiba.paciente.modelo.entidad.Paciente;
import com.ceiba.paciente.puerto.repositorio.RepositorioPaciente;
import com.ceiba.paciente.servicio.testdatabuilder.PacienteTestDataBuilder;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

public class ServicioActualizarPacienteTest {

    @Test
    public void actualizarPacienteTest() {

        // arrange
        Paciente paciente = new PacienteTestDataBuilder().id(null).build();
        RepositorioPaciente repositorioPaciente = Mockito.mock(RepositorioPaciente.class);
        ServicioActualizarPaciente servicioActualizarPaciente = new ServicioActualizarPaciente(repositorioPaciente);
        // act - assert
        Assertions.assertThrows(Exception.class, () -> servicioActualizarPaciente.ejecutar(paciente));
    }
}
