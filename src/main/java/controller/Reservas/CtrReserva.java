package controller.Reservas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import javax.swing.JOptionPane;
import model.ReservaModel;
import model.Usuarios.Usuario;
import view.Reservas.FrmReserva;
import model.DbReserva;

/**
 *
 * @author Martin
 */
public class CtrReserva {
    private ReservaModel modelo;
    private FrmReserva vista;
    private DbReserva dbR;
    
    public CtrReserva(ReservaModel modelo, FrmReserva vista, DbReserva dbR) {
        this.modelo = modelo;
        this.vista = vista;
        this.dbR = dbR;
        this.insertarImagenes();

        // Agregar eventos a los componentes de la vista
        this.vista.getComboEspacios().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarImagen();
            }
        });

        this.vista.getBtnReservar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                confirmarReserva();
                
            }
        });
        
        actualizarImagen();
        //setDisponibilidad();
        
    }
    
    
    private void insertarImagenes(){
        this.modelo.setImagenesEspacios(new HashMap<>());
        //this.modelo.getImagenesEspacios() = new HashMap<>();
        this.modelo.getImagenesEspacios().put("Piscina", "/imagenes/imagenesEspaciosComunes/piscina.png");
        this.modelo.getImagenesEspacios().put("Barbacoa", "/imagenes/imagenesEspaciosComunes/barbacoa.jpg");
        this.modelo.getImagenesEspacios().put("Gimnasio", "/imagenes/imagenesEspaciosComunes/gimnasio.jpg");
        this.modelo.getImagenesEspacios().put("Canchas", "/imagenes/imagenesEspaciosComunes/canchas.jpg");
        this.modelo.getImagenesEspacios().put("Salon", "/imagenes/imagenesEspaciosComunes/salon.jpg");
    }
    
    public void iniciar(){
        vista.setTitle("Reservas");
        vista.setLocationRelativeTo(null);
    }

    private void actualizarImagen() {
        String espacioSeleccionado = (String) vista.getComboEspacios().getSelectedItem();
        String rutaImagen = modelo.getImagenEspacio(espacioSeleccionado);
        vista.setImagenEspacio(rutaImagen);
    }

    private void confirmarReserva() {
        Date fechaSeleccionada = vista.getDateChooser().getDate();
        String espacio = (String) vista.getComboEspacios().getSelectedItem();
        String horaInicio = (String) vista.getComboHoraInicio().getSelectedItem();
        String horaFin = (String) vista.getComboHoraFin().getSelectedItem();
        if (fechaSeleccionada != null&& horaInicio != null && horaFin != null && espacio != null) {
            
            SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
            String fechaFormateada = formato.format(fechaSeleccionada);
            if(estaDisponible()){
                //setDisponibilidad();
                dbR.reservar(fechaFormateada, horaInicio, horaFin, espacio);
                JOptionPane.showMessageDialog(vista, "Reserva Confirmada\nEspacio: " + espacio + "\nFecha: " + fechaFormateada);
            }else{
                JOptionPane.showMessageDialog(vista, "Fecha no disponible, \npor favor escoger otra");

            }
            
        } else {
            JOptionPane.showMessageDialog(vista, "Por favor seleccione una fecha.");
        }
    }
    
    
    
    
    private boolean estaDisponible(){
        Date fechaSeleccionada = vista.getDateChooser().getDate();
        String espacioSeleccionado = (String) vista.getComboEspacios().getSelectedItem();
        String horaInicio = (String) vista.getComboHoraInicio().getSelectedItem();
        String horaFin = (String) vista.getComboHoraFin().getSelectedItem();
        if (fechaSeleccionada != null && espacioSeleccionado != null && horaInicio != null && horaFin != null) {
            SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
            String fechaFormateada = formato.format(fechaSeleccionada);
            
            return !dbR.estaReservado(fechaFormateada, horaInicio, horaFin, espacioSeleccionado);
        }
        
        return false;
    }
    
    /*
    private void setDisponibilidad(){
        if(estaDisponible()){
            vista.getLabelDisponibilidad().setText("Fecha Disponible");
        }else{
            
            vista.getLabelDisponibilidad().setText("Fecha No Disponible");
        }
    }*/
    
    
}

