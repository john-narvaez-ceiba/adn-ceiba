INSERT INTO paciente(noCedula,nombre,apellido,direccion,telefono)
VALUES
(2,'AAAAA','AAAAA','AAAAA','AAAAA');

INSERT INTO cita(idPaciente,valorOriginal,valorDescuento,descuento,efectivo,fechaCita)
VALUES
(1,1,0,0,0,now())