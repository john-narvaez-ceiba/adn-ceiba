
CREATE TABLE IF NOT EXISTS paciente (
    id INT(11) NOT NULL auto_increment,
    noCedula INTEGER NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    direccion VARCHAR(100) NOT NULL,
    telefono VARCHAR (20) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS cita (
    id INT(11) NOT NULL auto_increment,
    idPaciente INT(11) NOT NULL,
    valorOriginal INTEGER NOT NULL,
    valorDescuento INTEGER NULL,
    descuento INTEGER NULL,
    efectivo BOOLEAN NULL ,
    fechaCita DATE NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY(idPaciente)
    REFERENCES paciente(id)
    ON DELETE CASCADE
);