package com.ceiba.cita.servicio.testdatabuilder;

import com.ceiba.cita.comando.ComandoCita;
import java.time.LocalDate;

public class ComandoCitaTestDataBuilder {

    private Long id;
    private Long idPaciente;
    private Integer valorOriginal;
    private Integer valorDescuento;
    private Integer descuento;
    private Boolean efectivo;
    private LocalDate fechaCita;

    public ComandoCitaTestDataBuilder() {
        idPaciente = 1L;
        valorOriginal = 10000;
        valorDescuento = 0;
        descuento = 0;
        efectivo = false;
        fechaCita = LocalDate.now();
    }

    public ComandoCitaTestDataBuilder id(Long id) {
        this.id = id;
        return this;
    }

    public ComandoCitaTestDataBuilder idPaciente(Long idPaciente) {
        this.idPaciente = idPaciente;
        return this;
    }

    public ComandoCitaTestDataBuilder valorOriginal(Integer valorOriginal) {
        this.valorOriginal = valorOriginal;
        return this;
    }

    public ComandoCitaTestDataBuilder valorDescuento(Integer valorDescuento) {
        this.valorDescuento = valorDescuento;
        return this;
    }

    public ComandoCitaTestDataBuilder descuento(Integer descuento) {
        this.descuento = descuento;
        return this;
    }

    public ComandoCitaTestDataBuilder descuento(Boolean efectivo) {
        this.efectivo = efectivo;
        return this;
    }

    public ComandoCitaTestDataBuilder fechaCita(LocalDate fechaCita) {
        this.fechaCita = fechaCita;
        return this;
    }

    public ComandoCita build() {
        return new ComandoCita(id,idPaciente,valorOriginal,valorDescuento,descuento,efectivo,fechaCita);
    }
}
