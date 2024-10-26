package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAORESERVA extends conexion {

    public List<Reserva> listarReservas() throws SQLException {
        List<Reserva> lista = new ArrayList<>();
        Connection cn = this.conectar();
        String sql = "SELECT * FROM reserva";
        PreparedStatement ps = cn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Reserva reserva = new Reserva();
            reserva.setIdReserva(rs.getInt("IDRESERVA"));
            reserva.setIdAlojamiento(rs.getInt("IDALOJAMIENTO"));
            reserva.setIdUsuario(rs.getInt("IDUSUARIO"));
            reserva.setFechaInicio(rs.getDate("FECHA_INICIO"));
            reserva.setFechaFin(rs.getDate("FECHA_FIN"));
            lista.add(reserva);
        }
        rs.close();
        ps.close();
        cn.close();
        return lista;
    }

    public boolean agregarReserva(Reserva reserva) throws SQLException {
        String sql = "INSERT INTO reserva (IDALOJAMIENTO, IDUSUARIO, FECHA_INICIO, FECHA_FIN, TOTAL) VALUES (?, ?, ?, ?, ?)";
        try (Connection cn = this.conectar();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, reserva.getIdAlojamiento());
            ps.setInt(2, reserva.getIdUsuario());
            ps.setDate(3, new java.sql.Date(reserva.getFechaInicio().getTime()));
            ps.setDate(4, new java.sql.Date(reserva.getFechaFin().getTime()));
            ps.setDouble(5, reserva.getTotal());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al agregar reserva: " + e.getMessage());
            return false;
        }
    }

    public boolean editarReserva(Reserva reserva) throws SQLException {
        String sql = "UPDATE reserva SET IDALOJAMIENTO = ?, IDUSUARIO = ?, FECHA_INICIO = ?, FECHA_FIN = ? WHERE IDRESERVA = ?";
        try (Connection cn = this.conectar();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, reserva.getIdAlojamiento());
            ps.setInt(2, reserva.getIdUsuario());
            ps.setDate(3, new java.sql.Date(reserva.getFechaInicio().getTime()));
            ps.setDate(4, new java.sql.Date(reserva.getFechaFin().getTime()));
            ps.setInt(5, reserva.getIdReserva());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al editar reserva: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminarReserva(int idReserva) throws SQLException {
        String sql = "DELETE FROM reserva WHERE IDRESERVA = ?";
        try (Connection cn = this.conectar();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, idReserva);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar reserva: " + e.getMessage());
            return false;
        }
    }
}
