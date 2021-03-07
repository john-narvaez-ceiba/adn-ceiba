package com.ceiba.paciente.comando;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoPaciente {

    private Long id;
    private Integer noCedula;
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;
}
