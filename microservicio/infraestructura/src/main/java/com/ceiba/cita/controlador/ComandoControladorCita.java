package com.ceiba.cita.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.cita.comando.ComandoCita;
import com.ceiba.cita.comando.manejador.ManejadorActualizarCita;
import com.ceiba.cita.comando.manejador.ManejadorCrearCita;
import com.ceiba.cita.comando.manejador.ManejadorEliminarCita;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/cita")
@Api(tags = { "Controlador comando cita"})
public class ComandoControladorCita {

    private final ManejadorCrearCita manejadorCrearCita;
    private final ManejadorActualizarCita manejadorActualizarCita;
    private final ManejadorEliminarCita manejadorEliminarCita;

    public ComandoControladorCita(ManejadorCrearCita manejadorCrearCita, ManejadorEliminarCita manejadorEliminarCita, ManejadorActualizarCita manejadorActualizarCita) {
        this.manejadorCrearCita = manejadorCrearCita;
        this.manejadorEliminarCita = manejadorEliminarCita;
        this.manejadorActualizarCita = manejadorActualizarCita;
    }

    @PostMapping
    @ApiOperation("Crear Cita")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoCita comandoCita) throws IOException {
        return manejadorCrearCita.ejecutar(comandoCita);
    }

    @PutMapping(value="/{id}")
    @ApiOperation("Actualizar Cita")
    public void actualizar(@RequestBody ComandoCita comandoCita, @PathVariable Long id) throws IOException {
        comandoCita.setId(id);
        manejadorActualizarCita.ejecutar(comandoCita);
    }

    @DeleteMapping(value="/{id}")
    @ApiOperation("Eliminar Cita")
    public void eliminar(@PathVariable Long id) throws IOException {
        manejadorEliminarCita.ejecutar(id);
    }
}
