package com.ceiba.paciente.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
@Getter
@AllArgsConstructor
public class DtoPaciente {

    private Long id;
    private Integer noCedula;
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;
}
