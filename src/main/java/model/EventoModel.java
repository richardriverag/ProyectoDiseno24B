/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author DANIEL
 */
public class EventoModel {
    private int iD_Evento;
    private int tipo;
    private String descripcion;
    private int administrador_ID;

    public EventoModel(int iD_Evento, int tipo, String descripcion, int administrador_ID) {
        this.iD_Evento = iD_Evento;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.administrador_ID = administrador_ID;
    }

    public int getiD_Evento() {
        return iD_Evento;
    }

    public int getTipo() {
        return tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getAdministrador_ID() {
        return administrador_ID;
    }

    public void setiD_Evento(int iD_Evento) {
        this.iD_Evento = iD_Evento;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setAdministrador_ID(int administrador_ID) {
        this.administrador_ID = administrador_ID;
    }
    
    
}
