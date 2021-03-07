package com.ceiba.paciente.controlador;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.ceiba.ApplicationMock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= ApplicationMock.class)
@WebMvcTest(ConsultaControladorPaciente.class)
public class ConsultaControladorPacienteTest {

    private static final Integer DEFAULT_NO_CEDULA = 2;
    private static final String DEFAULT_NOMBRE = "AAAAA";
    private static final String DEFAULT_APELLIDO = "AAAAA";
    private static final String DEFAULT_DIRECCION = "AAAAA";
    private static final String DEFAULT_TELEFONO = "AAAAA";
    private static final String TEST_API_URL = "/paciente";

    @Autowired
    private MockMvc mocMvc;

    @Test
    public void listar() throws Exception {
        // arrange

        // act - assert
        mocMvc.perform(get(TEST_API_URL)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$.[*].noCedula").value(DEFAULT_NO_CEDULA))
                .andExpect(jsonPath("$.[*].nombre").value(DEFAULT_NOMBRE))
                .andExpect(jsonPath("$.[*].apellido").value(DEFAULT_APELLIDO))
                .andExpect(jsonPath("$.[*].direccion").value(DEFAULT_DIRECCION))
                .andExpect(jsonPath("$[*].telefono").value(DEFAULT_TELEFONO));
    }
}
