/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author LENOVO.USER
 */
public class Usuario {
    
    private int id;
    private String cedula;
    private String nombre;
    private String email;
    private String constrasenia;
    private String celular;
    private Rol rol;
    private double salario;
    private Date fechaContrato;

    public Usuario(int id, String cedula, String nombre, String email, String constrasenia, String celular, Rol rol, double salario, Date fechaContrato) {
        this.id = id;
        this.cedula = cedula;
        this.nombre = nombre;
        this.email = email;
        this.constrasenia = constrasenia;
        this.celular = celular;
        this.rol = rol;
        this.salario = salario;
        this.fechaContrato = fechaContrato;
    } 

    public Usuario(int id, String nombre, String constrasenia) {
        this.id = id;
        this.nombre = nombre;
        this.constrasenia = constrasenia;
    }

    

    public Usuario(String nombre, String constrasenia) {
        this.nombre = nombre;
        this.constrasenia = constrasenia;
    }
    
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

    public String getConstrasenia() {
        return constrasenia;
    }

    public void setConstrasenia(String constrasenia) {
        this.constrasenia = constrasenia;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Date getFechaContrato() {
        return fechaContrato;
    }

    public void setFechaContrato(Date fechaContrato) {
        this.fechaContrato = fechaContrato;
    }
    
    
}
