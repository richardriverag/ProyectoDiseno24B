/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author DANIEL
 */
public class AlertaModel {
    private int iD_Alerta;
    private int tipo;
    private String mensaje;
    private int administrador_ID;

    public AlertaModel(int iD_Alerta, int tipo, String mensaje, int administrador_ID) {
        this.iD_Alerta = iD_Alerta;
        this.tipo = tipo;
        this.mensaje = mensaje;
        this.administrador_ID = administrador_ID;
    }

    public int getiD_Alerta() {
        return iD_Alerta;
    }

    public int getTipo() {
        return tipo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public int getAdministrador_ID() {
        return administrador_ID;
    }

    public void setiD_Alerta(int iD_Alerta) {
        this.iD_Alerta = iD_Alerta;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public void setAdministrador_ID(int administrador_ID) {
        this.administrador_ID = administrador_ID;
    }
    
    
    
}
