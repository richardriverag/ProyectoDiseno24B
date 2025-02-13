/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReservaEspacioDAO {

    // Método para obtener todas las reservas de la base de datos
    public static void consultarReservas() {
        // Solo seleccionamos espacio_id, fecha y la concatenación de hora_inicio - hora_fin
        String sql = "SELECT espacio_id, fecha, CONCAT(hora_inicio, ' - ', hora_fin) AS horario FROM ReservaEspacio";

        try (Connection conn = Conexion.getInstance();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            System.out.println("Listado de Reservas:");
            System.out.println("---------------------------------------------");
            System.out.printf("%-10s %-12s %-20s%n", "Espacio", "Fecha", "Horario");
            System.out.println("---------------------------------------------");

            while (rs.next()) {
                int espacioId = rs.getInt("espacio_id");
                String fecha = rs.getString("fecha");
                String horario = rs.getString("horario");

                System.out.printf("%-10d %-12s %-20s%n", espacioId, fecha, horario);
            }

        } catch (SQLException e) {
            System.err.println("Error al consultar las reservas: " + e.getMessage());
        }
    }

}
