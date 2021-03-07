package com.ceiba.paciente.servicio;

import com.ceiba.paciente.modelo.entidad.Paciente;
import com.ceiba.paciente.puerto.repositorio.RepositorioPaciente;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.paciente.servicio.testdatabuilder.PacienteTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;

public class ServicioCrearPacienteTest {

    @Test
    public void validarExistenciaPreviaTest() {
        // arrange
        Paciente paciente = new PacienteTestDataBuilder().build();
        RepositorioPaciente repositorioPaciente = Mockito.mock(RepositorioPaciente.class);
        Mockito.when(repositorioPaciente.existe(Mockito.anyInt())).thenReturn(true);
        ServicioCrearPaciente servicioCrearPaciente = new ServicioCrearPaciente(repositorioPaciente);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearPaciente.ejecutar(paciente), ExcepcionDuplicidad.class,"El paciente ya existe en el sistema");
    }
}
