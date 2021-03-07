package com.ceiba.paciente.servicio.testdatabuilder;

import com.ceiba.paciente.modelo.entidad.Paciente;

public class PacienteTestDataBuilder {

    private Long id;
    private Integer noCedula;
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;

    public PacienteTestDataBuilder() {
        noCedula = 1082215681;
        nombre = "John";
        apellido = "Narvaez";
        direccion = "Neiva";
        telefono =  "3115364067";
    }

    public PacienteTestDataBuilder id(Long id) {
        this.id = id;
        return this;
    }

    public PacienteTestDataBuilder noCedula(Integer noCedula) {
        this.noCedula = noCedula;
        return this;
    }

    public PacienteTestDataBuilder nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public PacienteTestDataBuilder apellido(String apellido) {
        this.apellido = apellido;
        return this;
    }

    public PacienteTestDataBuilder direccion(String direccion) {
        this.direccion = direccion;
        return this;
    }

    public PacienteTestDataBuilder telefono(String telefono) {
        this.telefono = telefono;
        return this;
    }

    public Paciente build() {
        return new Paciente(id,noCedula,nombre,apellido,direccion,telefono);
    }
}
