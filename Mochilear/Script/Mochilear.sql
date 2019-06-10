
-- BASE DE DATOS PARA VAMOS A MOCHILEAR

-- Borrar la base de datos
DROP DATABASE   IF     EXISTS Mochilear;
-- Crear la base de datos
CREATE DATABASE IF NOT EXISTS Mochilear;
USE Mochilear;

-- NOTA : DATE_FORMAT("2017-06-15", "%Y %m %d");
-- Tabla cliente
CREATE TABLE Cliente(
  cedula VARCHAR(10),
  nombre VARCHAR(50),
  telefono VARCHAR(10) NOT NULL,
  correo VARCHAR(40),
  residencia VARCHAR(50),
  observaciones VARCHAR(255),
  CONSTRAINT PK_Cliente PRIMARY KEY (telefono)
)engine = innodb;

-- Tabla provincia
CREATE TABLE Provincia(
	numero INT NOT NULL,
    nombre VARCHAR(20),
    CONSTRAINT PK_Provincia PRIMARY KEY (numero)
)engine = innodb;

-- Tabla lugar
CREATE TABLE Lugar(
	provincia INT NOT NULL,
    nombre VARCHAR(50) NOT NULL,
    direccion VARCHAR(255),
    descripcion varchar (255),
    pos_x DOUBLE,
    pos_y DOUBLE,
    CONSTRAINT PK_Lugar PRIMARY KEY (nombre),
    CONSTRAINT FK_Lugar FOREIGN KEY (provincia) REFERENCES Provincia(numero)
)engine = innodb;

-- Tabla viaje
CREATE TABLE Viaje(
	lugar VARCHAR(50) NOT NULL,
    precio FLOAT,
    fecha_salida DATE,
    lugar_salida VARCHAR(50),
    CONSTRAINT PK_Viaje PRIMARY KEY (lugar,fecha_salida,lugar_salida),
    CONSTRAINT FK_Viaje FOREIGN KEY (lugar) REFERENCES Lugar(nombre)        
);

-- Tabla Buseta
CREATE TABLE Buseta(
	proveedor VARCHAR (50),
    asientos_totales INT,
    asientos_disponibles INT,
    telefono VARCHAR(10),
	lugar VARCHAR(50) NOT NULL,
    fecha_salida DATE,
    lugar_salida VARCHAR(50), 
    CONSTRAINT FK_Buseta FOREIGN KEY (lugar,fecha_salida,lugar_salida)
    REFERENCES Viaje(lugar,fecha_salida,lugar_salida)
);

-- Tabla cliente/lugar
CREATE TABLE Cliente_Viaje(
    cliente VARCHAR(10),
    fecha DATE,
    precio FLOAT,
	lugar VARCHAR(50),
    fecha_salida DATE,
    lugar_salida VARCHAR(50), 
    campos INT,
	CONSTRAINT FK_Cliente_Viaje FOREIGN KEY (lugar,fecha_salida,lugar_salida)
    REFERENCES Viaje(lugar,fecha_salida,lugar_salida),
    CONSTRAINT FK_Cliente Foreign Key (cliente) REFERENCES Cliente (telefono)
)engine = innodb;


-- INSERTS

-- Clientes
INSERT INTO Cliente (cedula,nombre,telefono,correo,residencia,observaciones) 
VALUES('402310453','Andres Gutierrez','61688613','andres.gutierrez.arcia@gmail.com','Barva',' Es un amigo');
INSERT INTO Cliente (cedula,nombre,telefono,correo, residencia,observaciones) 
VALUES('1111111111','Javier Mejias','60032438','josema2415.c@gmail.com','Desamparados','Es un amigo');

-- Provincias
INSERT INTO Provincia(numero,nombre) VALUES(1,'SAN JOSE');
INSERT INTO Provincia(numero,nombre) VALUES(2,'ALAJUELA');
INSERT INTO Provincia(numero,nombre) VALUES(3,'CARTAGO');
INSERT INTO Provincia(numero,nombre) VALUES(4,'HEREDIA');
INSERT INTO Provincia(numero,nombre) VALUES(5,'GUANACASTE');
INSERT INTO Provincia(numero,nombre) VALUES(6,'PUNTARENAS');
INSERT INTO Provincia(numero,nombre) VALUES(7,'LIMON');

-- Lugar
INSERT INTO Lugar values(6,'MANUEL ANTONIO','Quepos','Sol y playa',0,0);
INSERT INTO Lugar values(5,'ISLA SAN LUCAS','Nicoya','Sol, playa y una Isla',0,0);

-- Viaje
INSERT INTO Viaje values ('MANUEL ANTONIO',15000,'2018-07-01','SAN CARLOS');
INSERT INTO Viaje values ('MANUEL ANTONIO',13000,'2018-07-01','SAN JOSE');

-- Buseta
INSERT INTO Buseta VALUES ('Transportes Marvi',20,20,'61688613','MANUEL ANTONIO','2018-07-01','SAN CARLOS');

-- Cliente_Viaje
INSERT INTO Cliente_Viaje 
values('61688613',DATE_FORMAT(now(), "%Y-%m-%d"),8000,'MANUEL ANTONIO','2018-07-01','SAN JOSE',1);

