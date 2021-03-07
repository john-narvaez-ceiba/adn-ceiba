update paciente
set noCedula = :noCedula,
    nombre = :nombre,
    apellido = :apellido,
    direccion = :direccion,
    telefono = :telefono
where id = :id