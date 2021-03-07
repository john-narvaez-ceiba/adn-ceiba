package com.ceiba.cita.modelo.entidad;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
@Setter
public class Cita {

    private static final String REQUIRED_ID_PACIENTE = "Campo paciente es obligatorio";
    private static final String REQUIRED_VALOR_ORIGINAL = "Campo valor es obligatorio";
    private static final String REQUIRED_FECHA_CITA= "Campo fecha de cita es obligatorio";

    private Long id;
    private Long idPaciente;
    private Integer valorOriginal;
    private Integer valorDescuento;
    private Integer descuento;
    private Boolean efectivo;
    private LocalDate fechaCita;

    public Cita(Long id, Long idPaciente, Integer valorOriginal, Integer valorDescuento, Integer descuento, Boolean efectivo, LocalDate fechaCita) {
        validarObligatorio(idPaciente, REQUIRED_ID_PACIENTE);
        validarObligatorio(valorOriginal, REQUIRED_VALOR_ORIGINAL);
        validarObligatorio(fechaCita, REQUIRED_FECHA_CITA);

        this.id = id;
        this.idPaciente = idPaciente;
        this.valorOriginal = valorOriginal;
        this.valorDescuento = valorDescuento;
        this.descuento = descuento;
        this.efectivo = efectivo;
        this.fechaCita = fechaCita;
    }

}
