package com.ceiba.cita.servicio.testdatabuilder;

import com.ceiba.cita.modelo.entidad.Cita;
import java.time.LocalDate;

public class CitaTestDataBuilder {

    private Long id;
    private Long idPaciente;
    private Integer valorOriginal;
    private Integer valorDescuento;
    private Integer descuento;
    private Boolean efectivo;
    private LocalDate fechaCita;

    public CitaTestDataBuilder() {
        idPaciente = 1L;
        valorOriginal = 10000;
        valorDescuento = 0;
        descuento = 0;
        efectivo = false;
        fechaCita = LocalDate.now();
    }

    public CitaTestDataBuilder id(Long id) {
        this.id = id;
        return this;
    }

    public CitaTestDataBuilder idPaciente(Long idPaciente) {
        this.idPaciente = idPaciente;
        return this;
    }

    public CitaTestDataBuilder valorOriginal(Integer valorOriginal) {
        this.valorOriginal = valorOriginal;
        return this;
    }

    public CitaTestDataBuilder valorDescuento(Integer valorDescuento) {
        this.valorDescuento = valorDescuento;
        return this;
    }

    public CitaTestDataBuilder descuento(Integer descuento) {
        this.descuento = descuento;
        return this;
    }

    public CitaTestDataBuilder descuento(Boolean efectivo) {
        this.efectivo = efectivo;
        return this;
    }

    public CitaTestDataBuilder fechaCita(LocalDate fechaCita) {
        this.fechaCita = fechaCita;
        return this;
    }

    public Cita build() {
        return new Cita(id,idPaciente,valorOriginal,valorDescuento,descuento,efectivo,fechaCita);
    }

}
