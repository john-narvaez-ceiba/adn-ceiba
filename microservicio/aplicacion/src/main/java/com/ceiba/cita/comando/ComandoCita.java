package com.ceiba.cita.comando;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoCita {

    private Long id;
    private Long idPaciente;
    private Integer valorOriginal;
    private Integer valorDescuento;
    private Integer descuento;
    private Boolean efectivo;
    private LocalDate fechaCita;
}
