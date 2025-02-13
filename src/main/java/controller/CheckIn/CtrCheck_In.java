/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.CheckIn;

import model.Check_In.DbVisitante;
import model.Check_In.DbVehiculo;
import model.Check_In.DbRegistroEntrada;
import model.Check_In.Visitante;
import model.Check_In.Vehiculo;
import model.Check_In.RegistroEntrada;
import view.FrmCheckIn;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Controlador para el módulo de Check-In
 */
public class CtrCheck_In implements ActionListener {
    private FrmCheckIn frm;
    private DbVisitante dbVisitante = new DbVisitante();
    private DbVehiculo dbVehiculo = new DbVehiculo();
    private DbRegistroEntrada dbRegistro = new DbRegistroEntrada();

    public CtrCheck_In(FrmCheckIn frm) {
        this.frm = frm;
        this.frm.save.addActionListener(this);
        this.frm.clean.addActionListener(this);
        this.frm.update.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frm.save) {
            guardarDatos();
        } else if (e.getSource() == frm.clean) {
            limpiarFormulario();
        } else if (e.getSource() == frm.update) {
            actualizarTabla();
        }
    }

    private void guardarDatos() {
        Visitante visitante = new Visitante();
        visitante.setNombre(frm.name.getText());
        visitante.setIdentificacion(frm.identification.getText());
        visitante.setDetallesContacto(frm.contact.getText());
        visitante.setMotivoVisita(frm.reason.getText());
        
        if (dbVisitante.guardar(visitante)) {
            int visitanteId = dbVisitante.obtenerUltimoId();
            
            Vehiculo vehiculo = new Vehiculo();
            vehiculo.setPlaca(frm.plate.getText());
            vehiculo.setModelo(frm.model.getText());
            vehiculo.setColor(frm.color.getText());
            vehiculo.setVisitanteId(visitanteId);
            
            if (dbVehiculo.guardar(vehiculo)) {
                RegistroEntrada registro = new RegistroEntrada();
                registro.setFechaRegistro(new Date(System.currentTimeMillis()));
                registro.setVisitanteId(visitanteId);
                registro.setUsuarioId(1); // ID de usuario por defecto o dinámico
                
                if (dbRegistro.guardar(registro)) {
                    JOptionPane.showMessageDialog(null, "Datos guardados exitosamente.");
                    limpiarFormulario();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al guardar en RegistroEntrada.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar vehículo.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error al guardar visitante.");
        }
    }

    private void limpiarFormulario() {
        frm.name.setText("");
        frm.identification.setText("");
        frm.contact.setText("");
        frm.reason.setText("");
        frm.plate.setText("");
        frm.model.setText("");
        frm.color.setText("");
    }

    private void actualizarTabla() {
        List<RegistroEntrada> registros = dbRegistro.obtenerRegistros();
        DefaultTableModel model = (DefaultTableModel) frm.table.getModel();
        model.setRowCount(0);

        for (RegistroEntrada registro : registros) {
            Visitante visitante = dbVisitante.buscarPorId(registro.getVisitanteId());
            Vehiculo vehiculo = dbVehiculo.buscarPorVisitanteId(registro.getVisitanteId());
            
            model.addRow(new Object[]{
                registro.getFechaRegistro(),
                visitante.getId(),
                visitante.getNombre(),
                visitante.getIdentificacion(),
                visitante.getDetallesContacto(),
                visitante.getMotivoVisita(),
                vehiculo.getPlaca(),
                vehiculo.getModelo()
            });
        }
    }
}
