/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author DANIEL
 */
public class InmueblesModel {
    private int iD_Inmueble;
    private String direccion;
    private int estado;
    private int tipo;
    private String dimensiones;
    private int disponibilidad;
    private int user_ID;

    public InmueblesModel(int iD_Inmueble, String direccion, int estado, int tipo, String dimensiones, int disponibilidad, int user_ID) {
        this.iD_Inmueble = iD_Inmueble;
        this.direccion = direccion;
        this.estado = estado;
        this.tipo = tipo;
        this.dimensiones = dimensiones;
        this.disponibilidad = disponibilidad;
        this.user_ID = user_ID;
    }

    public int getiD_Inmueble() {
        return iD_Inmueble;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getEstado() {
        return estado;
    }

    public int getTipo() {
        return tipo;
    }

    public String getDimensiones() {
        return dimensiones;
    }

    public int getDisponibilidad() {
        return disponibilidad;
    }

    public int getUser_ID() {
        return user_ID;
    }

    public void setiD_Inmueble(int iD_Inmueble) {
        this.iD_Inmueble = iD_Inmueble;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public void setDimensiones(String dimensiones) {
        this.dimensiones = dimensiones;
    }

    public void setDisponibilidad(int disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public void setUser_ID(int user_ID) {
        this.user_ID = user_ID;
    }

    
    
    public InmueblesModel catalogo(int id){
        if(this.iD_Inmueble == id){
            return this;    
        }else{
        return null;
        }
    }
    
}
