/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.comunicacionModel;

import java.util.Date;



public class AnuncioGeneral {
    
    private int idAnuncio;
    private String contenido;
    private Date fechaCreacion;
    private UsuarioModel usuario; // Usuario que creo el anuncio
    
    // Constructor con parámetros
    public AnuncioGeneral(int idAnuncio, String contenido, Date fechaCreacion, UsuarioModel usuario) {
        this.idAnuncio = idAnuncio;
        this.contenido = contenido;
        this.fechaCreacion = fechaCreacion;
        this.usuario = usuario;
    }

    // Getters y Setters
    public int getIdAnuncio() {
        return idAnuncio;
    }

    public void setIdAnuncio(int idAnuncio) {
        this.idAnuncio = idAnuncio;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public UsuarioModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioModel usuario) {
        this.usuario = usuario;
    }
}