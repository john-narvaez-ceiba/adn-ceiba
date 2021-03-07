package com.ceiba.dominio.excepcion;

public class ExcepcionCita extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExcepcionCita(String mensaje) {
        super(mensaje);
    }
}
