package com.ceiba.paciente.servicio.testdatabuilder;

import com.ceiba.paciente.comando.ComandoPaciente;

import java.util.UUID;

public class ComandoPacienteTestDataBuilder {

    private Long id;
    private Integer noCedula;
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;

    public ComandoPacienteTestDataBuilder() {
        noCedula = 1;
        nombre = UUID.randomUUID().toString();
        apellido = UUID.randomUUID().toString();
        direccion = UUID.randomUUID().toString();
        telefono = UUID.randomUUID().toString().substring(20);
    }

    public ComandoPacienteTestDataBuilder id(Long id) {
        this.id = id;
        return this;
    }

    public ComandoPacienteTestDataBuilder noCedula(Integer noCedula) {
        this.noCedula = noCedula;
        return this;
    }

    public ComandoPacienteTestDataBuilder nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public ComandoPacienteTestDataBuilder apellido(String apellido) {
        this.apellido = apellido;
        return this;
    }

    public ComandoPacienteTestDataBuilder direccion(String direccion) {
        this.direccion = direccion;
        return this;
    }

    public ComandoPacienteTestDataBuilder telefono(String telefono) {
        this.telefono = telefono;
        return this;
    }

    public ComandoPaciente build() {
        return new ComandoPaciente(id,noCedula,nombre,apellido,direccion,telefono);
    }
}
