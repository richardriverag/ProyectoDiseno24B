/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.Check_In;

import model.Check_In.DatabaseConnection;
import view.check_in.Check_In;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CtrCheckIn implements ActionListener {
    private Check_In view;

    public CtrCheckIn(Check_In view) {
        this.view = view;
        this.view.save.addActionListener(this);
        this.view.update.addActionListener(this);
        this.view.clean.addActionListener(this);
        cargarDatosTabla();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.save) {
            guardarVisitanteVehiculo();
        } else if (e.getSource() == view.update) {
            cargarDatosTabla();
        } else if (e.getSource() == view.clean) {
            limpiarCampos();
        }
    }

    private void guardarVisitanteVehiculo() {
        String nombre = view.name.getText().trim();
        String identificacion = view.identification.getText().trim();
        String contacto = view.contact.getText().trim();
        String motivo = view.reason.getText().trim();
        String placa = view.plate.getText().trim();
        String modelo = view.model.getText().trim();
        String color = view.color.getText().trim();

        if (nombre.isEmpty() || identificacion.isEmpty() || contacto.isEmpty() || motivo.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Por favor, complete todos los campos obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try (Connection conn = DatabaseConnection.getConnection()) {
            String sqlVisitante = "INSERT INTO Visitante (nombre, identificacion, detallesContacto, motivoVisita) VALUES (?, ?, ?, ?)";
            PreparedStatement stmtVisitante = conn.prepareStatement(sqlVisitante, PreparedStatement.RETURN_GENERATED_KEYS);
            stmtVisitante.setString(1, nombre);
            stmtVisitante.setString(2, identificacion);
            stmtVisitante.setString(3, contacto);
            stmtVisitante.setString(4, motivo);
            stmtVisitante.executeUpdate();

            ResultSet generatedKeys = stmtVisitante.getGeneratedKeys();
            int visitanteId = -1;
            if (generatedKeys.next()) {
                visitanteId = generatedKeys.getInt(1);
            }

            if (!placa.isEmpty() && visitanteId != -1) {
                String sqlVehiculo = "INSERT INTO Vehiculo (placa, modelo, color, visitante_id) VALUES (?, ?, ?, ?)";
                PreparedStatement stmtVehiculo = conn.prepareStatement(sqlVehiculo);
                stmtVehiculo.setString(1, placa);
                stmtVehiculo.setString(2, modelo);
                stmtVehiculo.setString(3, color);
                stmtVehiculo.setInt(4, visitanteId);
                stmtVehiculo.executeUpdate();
            }

            JOptionPane.showMessageDialog(view, "Registro guardado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            limpiarCampos();
            cargarDatosTabla();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, "Error al guardar: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cargarDatosTabla() {
        DefaultTableModel modeloTabla = (DefaultTableModel) view.table.getModel();
        modeloTabla.setRowCount(0);  

        String sql = "SELECT v.id, v.nombre, v.identificacion, v.detallesContacto, v.motivoVisita, "
                   + "IFNULL(veh.placa, 'N/A'), IFNULL(veh.modelo, 'N/A'), IFNULL(veh.color, 'N/A') "
                   + "FROM Visitante v LEFT JOIN Vehiculo veh ON v.id = veh.visitante_id";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                modeloTabla.addRow(new Object[]{
                    rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
                    rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)
                });
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, "Error al cargar la tabla: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limpiarCampos() {
        view.name.setText("");
        view.identification.setText("");
        view.contact.setText("");
        view.reason.setText("");
        view.plate.setText("");
        view.model.setText("");
        view.color.setText("");
    }
}
