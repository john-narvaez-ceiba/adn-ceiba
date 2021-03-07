update cita
SET
    idPaciente = :idPaciente,
    valorOriginal = :valorOriginal,
    valorDescuento = :valorDescuento,
    descuento = :descuento,
    efectivo = :efectivo,
    fechaCita = :fechaCita
WHERE id = :id