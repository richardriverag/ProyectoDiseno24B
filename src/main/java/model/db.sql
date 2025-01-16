DROP DATABASE condominios;

CREATE DATABASE IF NOT EXISTS condominios;

USE condominios;

-- CREATE TABLE ...
-- Creación de la base de datos unificada
CREATE DATABASE IF NOT EXISTS SistemaUnificado;
USE SistemaUnificado;

-- Tabla Roles
CREATE TABLE Roles (
    id INT PRIMARY KEY,
    nombre VARCHAR(20) NOT NULL UNIQUE
);

-- Tabla Usuario
CREATE TABLE Usuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    cedula VARCHAR(20) NOT NULL UNIQUE,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    contrasenia VARCHAR(255) NOT NULL,
    celular VARCHAR(10) NOT NULL,
    rol_id INT NOT NULL,
    salario FLOAT DEFAULT NULL,
    fecha_contrato DATE DEFAULT NULL,
    FOREIGN KEY (rol_id) REFERENCES Roles(id)
);

-- Tabla Inmueble
CREATE TABLE Inmueble (
    id INT AUTO_INCREMENT PRIMARY KEY,
    direccion VARCHAR(255) NOT NULL,
    estado INT NOT NULL,
    usuario_id INT NOT NULL,
    FOREIGN KEY (usuario_id) REFERENCES Usuario(id)
);

-- Tabla SolicitudMantenimiento
CREATE TABLE SolicitudMantenimiento (
    id INT AUTO_INCREMENT PRIMARY KEY,
    descripcion TEXT NOT NULL,
    estado INT NOT NULL,
    residente_id INT NOT NULL,
    mantenimiento_id INT NOT NULL,
    FOREIGN KEY (residente_id) REFERENCES Usuario(id),
    FOREIGN KEY (mantenimiento_id) REFERENCES Usuario(id)
);

-- Tabla Alerta
CREATE TABLE Mensaje (
    id INT AUTO_INCREMENT PRIMARY KEY,
    contenido TEXT NOT NULL,
    fechaEnvio DATETIME NOT NULL,
    remitente_id INT NOT NULL,
    destinatario_id INT DEFAULT NULL,
    tipo ENUM('mensaje', 'comunicado', 'alerta') NOT NULL,
    FOREIGN KEY (remitente_id) REFERENCES Usuario(id),
    FOREIGN KEY (destinatario_id) REFERENCES Usuario(id)
);

-- Tabla Evento
CREATE TABLE Evento (
    id INT AUTO_INCREMENT PRIMARY KEY,
    tipo INT NOT NULL,
    descripcion TEXT NOT NULL,
    administrador_id INT NOT NULL,
    FOREIGN KEY (administrador_id) REFERENCES Usuario(id)
);

-- Tabla Reporte
CREATE TABLE Reporte (
    id INT AUTO_INCREMENT PRIMARY KEY,
    tipo INT NOT NULL,
    contenido TEXT NOT NULL,
    administrador_id INT NOT NULL,
    FOREIGN KEY (administrador_id) REFERENCES Usuario(id)
);

-- Tabla Transaccion
CREATE TABLE Transaccion (
    id INT AUTO_INCREMENT PRIMARY KEY,
    cedula_usuario VARCHAR(20) NOT NULL,
    monto DOUBLE NOT NULL,
    fecha DATE NOT NULL,
    tipo ENUM('multa', 'pago') NOT NULL,
    descripcion VARCHAR(255),
    estado BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (cedula_usuario) REFERENCES Usuario(cedula)
);

-- Tabla EspacioComun
CREATE TABLE EspacioComun (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    disponibilidad BOOLEAN NOT NULL
);

-- Relación EspacioComun_Vehiculo
CREATE TABLE EspacioComun_Vehiculo (
    idEspacio INT NOT NULL,
    idVehiculo INT NOT NULL,
    PRIMARY KEY (idEspacio, idVehiculo),
    FOREIGN KEY (idEspacio) REFERENCES EspacioComun(id),
    FOREIGN KEY (idVehiculo) REFERENCES Vehiculo(id)
);

-- Tabla Reserva
CREATE TABLE Reserva (
    id INT AUTO_INCREMENT PRIMARY KEY,
    cedula_residente VARCHAR(20),
    idEspacio INT,
    fechaReserva DATE NOT NULL,
    horaInicio TIME NOT NULL,
    horaFin TIME NOT NULL,
    estado VARCHAR(20) NOT NULL,
    FOREIGN KEY (cedula_residente) REFERENCES Usuario(cedula),
    FOREIGN KEY (idEspacio) REFERENCES EspacioComun(id)
);

-- Tabla Visitante
CREATE TABLE Visitante (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    identificacion VARCHAR(255) NOT NULL UNIQUE,
    detallesContacto VARCHAR(255) NOT NULL,
    motivoVisita VARCHAR(255) NOT NULL
);

-- Tabla Vehiculo
CREATE TABLE Vehiculo (
    id INT AUTO_INCREMENT PRIMARY KEY,
    placa VARCHAR(20) NOT NULL UNIQUE,
    modelo VARCHAR(100) NOT NULL,
    color VARCHAR(50) NOT NULL,
    visitante_id INT,
    FOREIGN KEY (visitante_id) REFERENCES Visitante(id) ON DELETE SET NULL
);

-- Tabla RegistroEntrada
CREATE TABLE RegistroEntrada (
    id INT AUTO_INCREMENT PRIMARY KEY,
    fechaRegistro DATE NOT NULL,
    visitante_id INT NOT NULL,
    guardia_id INT NOT NULL,
    FOREIGN KEY (visitante_id) REFERENCES Visitante(id),
    FOREIGN KEY (guardia_id) REFERENCES Usuario(id)
);

-- Relación Residente_Registro
CREATE TABLE Residente_Registro (
    residente_id INT NOT NULL,
    registro_id INT NOT NULL,
    PRIMARY KEY (residente_id, registro_id),
    FOREIGN KEY (residente_id) REFERENCES Usuario(id),
    FOREIGN KEY (registro_id) REFERENCES RegistroEntrada(id)
);
