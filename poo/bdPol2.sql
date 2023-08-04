CREATE TABLE PERSONAS (
    id INT NOT NULL auto_increment,
    identificacion VARCHAR(100) NOT NULL,
    correoElectronico VARCHAR(40) NOT NULL,
    numTarjeta INT NOT NULL, 
    rfc VARCHAR(13) NOT NULL,
    tipoIdentificacion VARCHAR(40) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE USUARIOS (
    id INT NOT NULL auto_increment,
    nombre VARCHAR(80),
    contrasena VARCHAR(90),
    superUsuario INT NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE AUTOS (
    id INT NOT NULL auto_increment,
    matricula VARCHAR(100),
    marca VARCHAR(100),
    modelo VARCHAR(200),
    observaciones VARCHAR(400),
    color VARCHAR(50),
    rentaPorDia DECIMAL(10,2),
    PRIMARY KEY (id)
);

CREATE TABLE PRESTAMOS (
    idAuto INT NOT NULL,
    idCliente INT NOT NULL,
    fechaRenta DATE,
    finalRenta DATE,
    lugarDeRenta VARCHAR(100),
    monto DECIMAL(10,2)
);

insert into USUARIOS (nombre,contrasena,superUsuario) values ('Paullette','admin',1);
