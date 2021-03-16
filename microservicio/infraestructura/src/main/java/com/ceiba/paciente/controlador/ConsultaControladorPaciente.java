package com.ceiba.paciente.controlador;

import java.util.List;

import com.ceiba.paciente.consulta.ManejadorListarPaciente;
import com.ceiba.paciente.consulta.ManejoListarPacienteId;
import org.springframework.web.bind.annotation.*;

import com.ceiba.paciente.modelo.dto.DtoPaciente;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/paciente")
@Api(tags={"Controlador consulta cita"})
public class ConsultaControladorPaciente {

    private final ManejadorListarPaciente manejadorListarPaciente;
    private final ManejoListarPacienteId manejoListarPacienteId;

    public ConsultaControladorPaciente(ManejadorListarPaciente manejadorListarPaciente, ManejoListarPacienteId manejoListarPacienteId) {
        this.manejadorListarPaciente = manejadorListarPaciente;
        this.manejoListarPacienteId = manejoListarPacienteId;
    }

    @GetMapping
    @ApiOperation("Listar Pacientes")
    public List<DtoPaciente> listar() {
        return this.manejadorListarPaciente.ejecutar();
    }

    @GetMapping(value="/{id}")
    @ApiOperation("Paciente by Id")
    public List<DtoPaciente> listarId(@PathVariable Long id) { return this.manejoListarPacienteId.ejecutar(id); }

}
