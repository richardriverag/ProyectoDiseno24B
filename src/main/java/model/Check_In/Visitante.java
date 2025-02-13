/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.Check_In;

import java.util.Date;

/**
 * Modelo de la estructura para Check-In
 * @author User
 */
public class Visitante {
    private int id;
    private String nombre;
    private String identificacion;
    private String detallesContacto;
    private String motivoVisita;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getDetallesContacto() {
        return detallesContacto;
    }

    public void setDetallesContacto(String detallesContacto) {
        this.detallesContacto = detallesContacto;
    }

    public String getMotivoVisita() {
        return motivoVisita;
    }

    public void setMotivoVisita(String motivoVisita) {
        this.motivoVisita = motivoVisita;
    }
}

