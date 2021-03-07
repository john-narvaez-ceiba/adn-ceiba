package com.ceiba.paciente.controlador;

import java.util.List;

import com.ceiba.paciente.consulta.ManejadorListarPaciente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.paciente.modelo.dto.DtoPaciente;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/paciente")
@Api(tags={"Controlador consulta cita"})
public class ConsultaControladorPaciente {

    private final ManejadorListarPaciente manejadorListarPaciente;

    public ConsultaControladorPaciente(ManejadorListarPaciente manejadorListarPaciente) {
        this.manejadorListarPaciente = manejadorListarPaciente;
    }

    @GetMapping
    @ApiOperation("Listar Pacientes")
    public List<DtoPaciente> listar() {
        return this.manejadorListarPaciente.ejecutar();
    }

}
