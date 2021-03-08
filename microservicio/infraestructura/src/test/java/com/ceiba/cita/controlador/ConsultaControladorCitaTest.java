package com.ceiba.cita.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.paciente.controlador.ConsultaControladorPaciente;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= ApplicationMock.class)
@WebMvcTest(ConsultaControladorPaciente.class)
public class ConsultaControladorCitaTest {

    private static final Integer DEFAULT_ID_PACIENTE = 1;
    private static final Integer DEFAULT_VALOR_ORIGINAL = 1;
    private static final Integer DEFAULT_VALOR_DESCUENTO = 0;
    private static final Integer DEFAULT_DESCUENTP = 0;
    private static final Boolean DEFAULT_EFECTIVO = false;
    private static final LocalDate DEFAULT_FECHA_CITA = LocalDate.now();
    private static final String TEST_API_URL = "/cita";

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
                .andExpect(jsonPath("$.[*].idPaciente").value(DEFAULT_ID_PACIENTE))
                .andExpect(jsonPath("$.[*].valorOriginal").value(DEFAULT_VALOR_ORIGINAL))
                .andExpect(jsonPath("$.[*].valorDescuento").value(DEFAULT_VALOR_DESCUENTO))
                .andExpect(jsonPath("$.[*].descuento").value(DEFAULT_DESCUENTP))
                .andExpect(jsonPath("$.[*].efectivo").value(DEFAULT_EFECTIVO))
                .andExpect(jsonPath("$[*].fechaCita").value(DEFAULT_FECHA_CITA.toString()));
    }
}
