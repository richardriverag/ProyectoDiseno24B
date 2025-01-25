/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author DANIEL
 */
public class SolicitudMantenimientoModel {
    private int iD_SolicitudMantenimiento;
    private String descripcion;
    private int estado;
    private int residente_ID;
    private int mantenimiento_ID;

    public SolicitudMantenimientoModel(int iD_SolicitudMantenimiento, String descripcion, int estado, int residente_ID, int mantenimiento_ID) {
        this.iD_SolicitudMantenimiento = iD_SolicitudMantenimiento;
        this.descripcion = descripcion;
        this.estado = estado;
        this.residente_ID = residente_ID;
        this.mantenimiento_ID = mantenimiento_ID;
    }

    public int getiD_SolicitudMantenimiento() {
        return iD_SolicitudMantenimiento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getEstado() {
        return estado;
    }

    public int getResidente_ID() {
        return residente_ID;
    }

    public int getMantenimiento_ID() {
        return mantenimiento_ID;
    }

    public void setiD_SolicitudMantenimiento(int iD_SolicitudMantenimiento) {
        this.iD_SolicitudMantenimiento = iD_SolicitudMantenimiento;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public void setResidente_ID(int residente_ID) {
        this.residente_ID = residente_ID;
    }

    public void setMantenimiento_ID(int mantenimiento_ID) {
        this.mantenimiento_ID = mantenimiento_ID;
    }
    
    
    
}
