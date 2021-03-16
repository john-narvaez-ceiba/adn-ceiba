package com.ceiba.cita.modelo.entidad;

import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.time.LocalDate;

import static com.ceiba.dominio.ValidadorArgumento.*;

@Getter
@Setter
public class Cita {

    private static final String REQUIRED_ID_PACIENTE = "Campo paciente es obligatorio";
    private static final String REQUIRED_VALOR_ORIGINAL = "Campo valor es obligatorio";
    private static final String VALIDAR_VALOR_POSITIVO = "No se permiten valores en negativos";
    private static final String REQUIRED_FECHA_CITA= "Campo fecha de cita es obligatorio";
    private static final String ERROR_DESCUENTO = "Error al aplicar el descuento";
    public static final int PORCENTAJE_DESCUEMTO = 3;
    public static final int DIVISOR = 100;

    private Long id;
    private Long idPaciente;
    private Integer valorOriginal;
    private Integer valorDescuento;
    private Integer descuento;
    private Boolean efectivo;
    private LocalDate fechaCita;

    public Cita(Long id, Long idPaciente, Integer valorOriginal, Integer valorDescuento, Integer descuento, Boolean efectivo, LocalDate fechaCita) throws IOException {

        validarObligatorio(idPaciente, REQUIRED_ID_PACIENTE);
        validarObligatorio(valorOriginal, REQUIRED_VALOR_ORIGINAL);
        validarObligatorio(fechaCita, REQUIRED_FECHA_CITA);

        validarPositivo(valorOriginal, VALIDAR_VALOR_POSITIVO);
        validarPagoEfectivo(valorOriginal, efectivo);

        this.id = id;
        this.idPaciente = idPaciente;
        this.valorOriginal = valorOriginal;
        this.efectivo = efectivo;
        this.fechaCita = fechaCita;
    }

    public void validarPagoEfectivo(Integer valorOriginal, Boolean efectivo) throws IOException {

        if(valorOriginal == null || efectivo == null) {
            throw new IOException(ERROR_DESCUENTO);
        }

        if(efectivo) {

            Integer sacarPorcentaje = (valorOriginal * PORCENTAJE_DESCUEMTO)/DIVISOR;
            Integer valorDescuento = valorOriginal - sacarPorcentaje;

            this.setValorDescuento(valorDescuento);
            this.setDescuento(PORCENTAJE_DESCUEMTO);
        }
    }
}
