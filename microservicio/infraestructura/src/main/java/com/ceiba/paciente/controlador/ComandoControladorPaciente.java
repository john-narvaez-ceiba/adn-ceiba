package com.ceiba.paciente.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.paciente.comando.ComandoPaciente;
import com.ceiba.paciente.comando.manejador.ManejadorActualizarPaciente;
import com.ceiba.paciente.comando.manejador.ManejadorCrearPaciente;
import com.ceiba.paciente.comando.manejador.ManejadorEliminarPaciente;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.io.IOException;

@RestController
@RequestMapping("/paciente")
@Api(tags = { "Controlador comando paciente"})
public class ComandoControladorPaciente {

    private final ManejadorCrearPaciente manejadorCrearPaciente;
	private final ManejadorEliminarPaciente manejadorEliminarPaciente;
	private final ManejadorActualizarPaciente manejadorActualizarPaciente;

	public ComandoControladorPaciente(ManejadorCrearPaciente manejadorCrearPaciente, ManejadorEliminarPaciente manejadorEliminarPaciente, ManejadorActualizarPaciente manejadorActualizarPaciente) {
		this.manejadorCrearPaciente = manejadorCrearPaciente;
		this.manejadorEliminarPaciente = manejadorEliminarPaciente;
		this.manejadorActualizarPaciente = manejadorActualizarPaciente;
	}

	@PostMapping
    @ApiOperation("Crear Paciente")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoPaciente comandoPaciente) {
        return manejadorCrearPaciente.ejecutar(comandoPaciente);
    }

	@PutMapping(value="/{id}")
	@ApiOperation("Actualizar Paciente")
	public void actualizar(@RequestBody ComandoPaciente comandoPaciente, @PathVariable Long id) throws IOException {
		comandoPaciente.setId(id);
		manejadorActualizarPaciente.ejecutar(comandoPaciente);
	}

    @DeleteMapping(value="/{id}")
	@ApiOperation("Eliminar Paciente")
	public void eliminar(@PathVariable Long id) throws IOException {
		manejadorEliminarPaciente.ejecutar(id);
	}
}
