/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author DANIEL
 */
public class ReporteModel {
    private int iD_Reporte;
    private int tipo;
    private String contenido;
    private int administrador_ID;

    public ReporteModel(int iD_Reporte, int tipo, String contenido, int administrador_ID) {
        this.iD_Reporte = iD_Reporte;
        this.tipo = tipo;
        this.contenido = contenido;
        this.administrador_ID = administrador_ID;
    }

    public int getiD_Reporte() {
        return iD_Reporte;
    }

    public int getTipo() {
        return tipo;
    }

    public String getContenido() {
        return contenido;
    }

    public int getAdministrador_ID() {
        return administrador_ID;
    }

    public void setiD_Reporte(int iD_Reporte) {
        this.iD_Reporte = iD_Reporte;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public void setAdministrador_ID(int administrador_ID) {
        this.administrador_ID = administrador_ID;
    }
    
    
}
