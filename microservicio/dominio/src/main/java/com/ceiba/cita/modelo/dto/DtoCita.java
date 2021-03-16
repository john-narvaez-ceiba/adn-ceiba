package com.ceiba.cita.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class DtoCita {

    private Long id;
    private Long idPaciente;
    private Integer valorOriginal;
    private Integer valorDescuento;
    private Integer descuento;
    private Boolean efectivo;
    private LocalDate fechaCita;
    private String nombre;
    private String apellido;
}
