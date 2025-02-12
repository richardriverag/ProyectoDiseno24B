/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.comunicacion;

import java.util.Date;
 


public class Mensaje {

    /**
     * Enumeración que representa los posibles tipos de mensaje.
     */
    public enum TipoMensaje {
        MENSAJE, COMUNICADO, ALERTA;
        public static TipoMensaje fromString(String tipo) {
            switch (tipo.toLowerCase()) {
                case "mensaje":
                    return MENSAJE;
                case "comunicado":
                    return COMUNICADO;
                case "alerta":
                    return ALERTA;
                default:
                    throw new IllegalArgumentException("Tipo de mensaje desconocido: " + tipo);
            }
        }
    }

    // Atributos que mapean la tabla Mensaje de la base de datos
    private int id;                
    private String contenido;       
    private Date fechaEnvio;        
    private UsuarioModel remitente;     
    private UsuarioModel destinatario; 
    private TipoMensaje tipo;      
  
    public Mensaje(int id, String contenido, Date fechaEnvio, UsuarioModel remitente, UsuarioModel destinatario, TipoMensaje tipo) {
        this.id = id;
        this.contenido = contenido;
        this.fechaEnvio = fechaEnvio;
        this.remitente = remitente;
        this.destinatario = destinatario;
        this.tipo = tipo;
    }

    // Getters y Setters

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getContenido() {
        return contenido;
    }
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
    public Date getFechaEnvio() {
        return fechaEnvio;
    }
    public void setFechaEnvio(Date fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }
    public UsuarioModel getRemitente() {
        return remitente;
    }
    public void setRemitente(UsuarioModel remitente) {
        this.remitente = remitente;
    }
    public UsuarioModel getDestinatario() {
        return destinatario;
    }
    public void setDestinatario(UsuarioModel destinatario) {
        this.destinatario = destinatario;
    }
    public TipoMensaje getTipo() {
        return tipo;
    }
    public void setTipo(TipoMensaje tipo) {
        this.tipo = tipo;
    }
}