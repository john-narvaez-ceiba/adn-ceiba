package com.ceiba.cita.controlador;

import com.ceiba.cita.consulta.ManejadorListarCitaId;
import com.ceiba.cita.modelo.dto.DtoCita;
import com.ceiba.cita.consulta.ManejadorListarCita;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cita")
@Api(tags={"Controlador consulta cita"})
public class ConsultaControladorCita {

    private final ManejadorListarCita manejadorListarCita;
    private final ManejadorListarCitaId manejadorListarCitaId;

    public ConsultaControladorCita(ManejadorListarCita manejadorListarCita, ManejadorListarCitaId manejadorListarCitaId) {
        this.manejadorListarCita = manejadorListarCita;
        this.manejadorListarCitaId = manejadorListarCitaId;
    }

    @GetMapping
    @ApiOperation("Listar Citas")
    public List<DtoCita> listar() {
        return this.manejadorListarCita.ejecutar();
    }

    @GetMapping(value="/{id}")
    @ApiOperation("Listar by Id")
    public List<DtoCita> listarId(@PathVariable Long id) {
        return this.manejadorListarCitaId.ejecutar(id);
    }
}
