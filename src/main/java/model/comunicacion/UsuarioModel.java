/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.comunicacionModel;

import java.util.Date;
import java.util.Objects;

/**
 * Clase que representa al usuario general del sistema.
 * Esta clase mapea la tabla Usuario de la base de datos y contiene
 * los métodos de negocio para la gestión de cuentas.
 */
public class UsuarioModel {

    // Atributos mapeados de la base de datos
    private int id;                 // id de la tabla (AUTO_INCREMENT)
    private String cedula;          // Cédula (única)
    private String nombre;          // Nombre completo
    private String email;           // Email (único)
    private String contrasenia;     // Contraseña
    private String celular;         // Número de celular
    private int rolId;              // Id del rol (relacionado con la tabla Roles)
    private Float salario;          // Salario (puede ser nulo)
    private Date fechaContrato;     // Fecha de contrato (puede ser nula)


    public UsuarioModel(int id, String cedula, String nombre, String email, String contrasenia, 
                   String celular, int rolId, Float salario, Date fechaContrato) {
        this.id = id;
        this.cedula = cedula;
        this.nombre = nombre;
        this.email = email;
        this.contrasenia = contrasenia;
        this.celular = celular;
        this.rolId = rolId;
        this.salario = salario;
        this.fechaContrato = fechaContrato;
    }

    // Getters y Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    } 

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public int getRolId() {
        return rolId;
    }

    public void setRolId(int rolId) {
        this.rolId = rolId;
    }

    public Float getSalario() {
        return salario;
    }

    public void setSalario(Float salario) {
        this.salario = salario;
    }

    public Date getFechaContrato() {
        return fechaContrato;
    }

    public void setFechaContrato(Date fechaContrato) {
        this.fechaContrato = fechaContrato;
    }
    
    
}
