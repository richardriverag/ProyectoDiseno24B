/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.Usuarios;

/**
 *
 * @author LENOVO.USER
 */
public class RolModel {
    
    private int id;
    private String nombre;

    public RolModel(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    
    public RolModel(int id) {
        this.id = id;
    }
    
    

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
    
    
}
