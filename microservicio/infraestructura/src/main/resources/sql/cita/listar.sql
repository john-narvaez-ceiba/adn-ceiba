SELECT
    c.id,
    c.idPaciente ,
    c.valorOriginal,
    c.valorDescuento,
    c.descuento,
    c.efectivo,
    c.fechaCita,
    p.nombre,
    p.apellido
FROM cita c, paciente p WHERE c.idPaciente  = p.id;