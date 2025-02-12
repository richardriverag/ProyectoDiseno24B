/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.comunicacionModel;

import java.util.Date;
import model.comunicacion.UsuarioModel;


public class ReporteMensaje {

    private int idReporte;
    private Date fechaInicio;
    private Date fechaFinal;
    private String contenido;
    private UsuarioModel usuario; 

    // Constructor con parámetros
    public ReporteMensaje(int idReporte, Date fechaInicio, Date fechaFinal, String contenido, UsuarioModel usuario) {
        this.idReporte = idReporte;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.contenido = contenido;
        this.usuario = usuario;
    }

    // Getters y Setters
    public int getIdReporte() {
        return idReporte;
    }

    public void setIdReporte(int idReporte) {
        this.idReporte = idReporte;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public UsuarioModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioModel usuario) {
        this.usuario = usuario;
    }
}