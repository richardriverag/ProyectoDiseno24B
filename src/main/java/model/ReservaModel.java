package model;

import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author Martin
 */
public class ReservaModel {
    private HashMap<String, String> imagenesEspacios;
    private int idReserva;
    private Date fechaReserva;
    private String horaInicio;
    private String horaFin;
    private String estado;

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public Date getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(Date fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public HashMap<String, String> getImagenesEspacios() {
        return imagenesEspacios;
    }
    
    public void setImagenesEspacios(HashMap<String, String> imagenesEspacios) {
        this.imagenesEspacios = imagenesEspacios;
    }
    
    public String getImagenEspacio(String espacio){
         return imagenesEspacios.getOrDefault(espacio, "src/images/default.jpg");

    }
    
    

    
    
    
    
    
}
