package com.ceiba.paciente.modelo.entidad;

import lombok.Getter;
import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Paciente {

    private static final String REQUIRED_NO_CEDULA = "Campo No. de Cédula es obligatorio";
    private static final String REQUIRED_NOMBRE = "Campo nombre es obligatorio";
    private static final String REQUIRED_APELLIDO = "Campo apellido es obligatorio";
    private static final String REQUIRED_DIRECCION = "Campo dirección es obligatorio";
    private static final String REQUIRED_TELEFONO = "Campo teléfono es obligatorio";

    private Long id;
    private Integer noCedula;
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;

    public Paciente(Long id,Integer noCedula,String nombre,String apellido,String direccion,String telefono) {
        validarObligatorio(noCedula, REQUIRED_NOMBRE);
        validarObligatorio(nombre, REQUIRED_NOMBRE);
        validarObligatorio(apellido, REQUIRED_APELLIDO);
        validarObligatorio(direccion, REQUIRED_DIRECCION);
        validarObligatorio(telefono, REQUIRED_TELEFONO);

        this.id = id;
        this.noCedula = noCedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
    }

}
