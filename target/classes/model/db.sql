DROP DATABASE condominios;
CREATE DATABASE IF NOT EXISTS condominios;
USE condominios;

-- CREATE TABLE ...
-- Creación de la base de datos unificada
CREATE DATABASE IF NOT EXISTS SistemaUnificado;
USE SistemaUnificado;

-- MÓDULO DE USUARIOS
-- Tabla Roles
CREATE TABLE Roles (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) UNIQUE NOT NULL
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
    FOREIGN KEY (rol_id) REFERENCES Roles(id) ON DELETE CASCADE
);

-- MÓDULO FINANZAS Y PAGOS
CREATE TABLE MetodoPago (
    id INT PRIMARY KEY AUTO_INCREMENT,
    tipo VARCHAR(50) NOT NULL
);
CREATE TABLE Pago (
    id INT PRIMARY KEY AUTO_INCREMENT,
    usuario_id INT NOT NULL,
    monto DECIMAL(10, 2) NOT NULL,
    fecha DATE NOT NULL,
    metodo_pago_id INT NOT NULL,
    FOREIGN KEY (usuario_id) REFERENCES Usuario(id),
    FOREIGN KEY (metodo_pago_id) REFERENCES MetodoPago(id)
);
CREATE TABLE Multa (
    id INT PRIMARY KEY AUTO_INCREMENT,
    usuario_id INT NOT NULL,
    monto DECIMAL(10, 2) NOT NULL,
    descripcion TEXT NOT NULL,
    fecha DATE NOT NULL,
    FOREIGN KEY (usuario_id) REFERENCES Usuario(id)
);
CREATE TABLE Cuota (
    id INT PRIMARY KEY AUTO_INCREMENT,
    pago_id INT NOT NULL,
    monto DECIMAL(10, 2) NOT NULL,
    fecha_pago DATE NOT NULL,
    estado ENUM('Pendiente', 'Pagado') NOT NULL,
    FOREIGN KEY (pago_id) REFERENCES Pago(id)
);

-- MODULO DE RESIDENTES
CREATE TABLE Inmueble (
    id INT PRIMARY KEY AUTO_INCREMENT,
    direccion VARCHAR(255) NOT NULL,
    estado VARCHAR(50) NOT NULL  
);

CREATE TABLE SolicitudMantenimiento (
    id INT PRIMARY KEY AUTO_INCREMENT,
    usuario_id INT NOT NULL,  
    inmueble_id INT NOT NULL, 
    descripcion TEXT NOT NULL,
    estado VARCHAR(50) NOT NULL, 
    FOREIGN KEY (usuario_id) REFERENCES Usuario(id),
    FOREIGN KEY (inmueble_id) REFERENCES Inmueble(id)
);

CREATE TABLE ReservaInmueble (
    id INT PRIMARY KEY AUTO_INCREMENT,
    usuario_id INT NOT NULL, 
    inmueble_id INT NOT NULL, 
    fecha_reserva DATE NOT NULL,  
    fecha_inicio DATE NOT NULL,  
    fecha_fin DATE NOT NULL,      
    FOREIGN KEY (usuario_id) REFERENCES Usuario(id),
    FOREIGN KEY (inmueble_id) REFERENCES Inmueble(id)
);

-- MÓDULO RESERVAS
CREATE TABLE EspacioComun (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,  
    disponibilidad BOOLEAN NOT NULL  
);

CREATE TABLE ReservaEspacio (
    id INT PRIMARY KEY AUTO_INCREMENT,
    usuario_id INT NOT NULL,  
    espacio_id INT NOT NULL,  
    fecha DATE NOT NULL,  
    hora_inicio TIME NOT NULL,  
    hora_fin TIME NOT NULL,
    estado VARCHAR(50) NOT NULL,  
    FOREIGN KEY (usuario_id) REFERENCES Usuario(id),
    FOREIGN KEY (espacio_id) REFERENCES EspacioComun(id)
);


-- MÓDULO CHECK-IN
CREATE TABLE Visitante (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    identificacion VARCHAR(20) UNIQUE NOT NULL,
    detalles_contacto VARCHAR(255),
    motivo_visita TEXT NOT NULL
);

CREATE TABLE Vehiculo (
    id INT PRIMARY KEY AUTO_INCREMENT,
    placa VARCHAR(15) UNIQUE NOT NULL,  
    modelo VARCHAR(50) NOT NULL,       
    color VARCHAR(20) NOT NULL,         
    visitante_id INT NOT NULL,          
    FOREIGN KEY (visitante_id) REFERENCES Visitante(id)
);

CREATE TABLE RegistroEntrada (
    id INT PRIMARY KEY AUTO_INCREMENT,
    fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  
    visitante_id INT NOT NULL,                         
    usuario_id INT NOT NULL,                             
    FOREIGN KEY (visitante_id) REFERENCES Visitante(id),
    FOREIGN KEY (usuario_id) REFERENCES Usuario(id)
);

-- MÓDULO COMUNICADO
CREATE TABLE Comunicado (
    id INT PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR(255) NOT NULL,          
    contenido TEXT NOT NULL,               
    fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP, 
    tipo ENUM('global', 'residente', 'trabajador') NOT NULL, 
    enviado_por INT NOT NULL,              
    FOREIGN KEY (enviado_por) REFERENCES Usuario(id), 
    estado ENUM('activo', 'eliminado') DEFAULT 'activo'
);

CREATE TABLE MensajeDirecto (
    id INT PRIMARY KEY AUTO_INCREMENT,
    mensaje TEXT NOT NULL,                  
    fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP, 
    remitente_id INT NOT NULL,              
    destinatario_id INT NOT NULL,           
    FOREIGN KEY (remitente_id) REFERENCES Usuario(id),  
    FOREIGN KEY (destinatario_id) REFERENCES Usuario(id) 
);

CREATE TABLE Reporte (
    id INT PRIMARY KEY AUTO_INCREMENT,
    comunicado_id INT NOT NULL,           
    reporte TEXT NOT NULL,                 
    fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP, 
    enviado_por INT NOT NULL,             
    FOREIGN KEY (comunicado_id) REFERENCES Comunicado(id), 
    FOREIGN KEY (enviado_por) REFERENCES Usuario(id)      
);
