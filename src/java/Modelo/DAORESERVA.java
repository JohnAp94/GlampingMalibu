package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAORESERVA extends conexion {

    public List<Reserva> listarReservasConDetalles() throws SQLException {
        List<Reserva> lista = new ArrayList<>();
        String sql = "SELECT r.IDRESERVA, r.IDALOJAMIENTO, r.IDUSUARIO, r.FECHA_INICIO, r.FECHA_FIN, r.TOTAL, "
                   + "a.NOMBRE AS NOMBREALOJAMIENTO, u.NOMBREUSUARIO "
                   + "FROM reserva r "
                   + "INNER JOIN alojamiento a ON r.IDALOJAMIENTO = a.IDALOJAMIENTO "
                   + "INNER JOIN usuario u ON r.IDUSUARIO = u.IDUSUARIO ORDER BY r.IDRESERVA";

        try (Connection cn = this.conectar();
             PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Reserva reserva = new Reserva();
                reserva.setIdReserva(rs.getInt("IDRESERVA"));
                reserva.setIdAlojamiento(rs.getInt("IDALOJAMIENTO"));
                reserva.setIdUsuario(rs.getInt("IDUSUARIO"));
                reserva.setFechaInicio(rs.getDate("FECHA_INICIO"));
                reserva.setFechaFin(rs.getDate("FECHA_FIN"));
                reserva.setTotal(rs.getDouble("TOTAL"));
                reserva.setNombreAlojamiento(rs.getString("NOMBREALOJAMIENTO"));
                reserva.setNombreUsuario(rs.getString("NOMBREUSUARIO"));
                lista.add(reserva);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar reservas con detalles: " + e.getMessage());
            throw e;
        }
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
            throw e;
        }
    }

    public boolean editarReserva(Reserva reserva) throws SQLException {
        String sql = "UPDATE reserva SET IDALOJAMIENTO = ?, IDUSUARIO = ?, FECHA_INICIO = ?, FECHA_FIN = ?, TOTAL = ? WHERE IDRESERVA = ?";
        try (Connection cn = this.conectar();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, reserva.getIdAlojamiento());
            ps.setInt(2, reserva.getIdUsuario());
            ps.setDate(3, new java.sql.Date(reserva.getFechaInicio().getTime()));
            ps.setDate(4, new java.sql.Date(reserva.getFechaFin().getTime()));
            ps.setDouble(5, reserva.getTotal());
            ps.setInt(6, reserva.getIdReserva());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al editar reserva: " + e.getMessage());
            throw e;
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
            throw e;
        }
    }

    public Reserva obtenerReservaPorId(int idReserva) throws SQLException {
        String sql = "SELECT * FROM reserva WHERE IDRESERVA = ?";
        try (Connection cn = this.conectar();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, idReserva);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Reserva reserva = new Reserva();
                    reserva.setIdReserva(rs.getInt("IDRESERVA"));
                    reserva.setIdAlojamiento(rs.getInt("IDALOJAMIENTO"));
                    reserva.setIdUsuario(rs.getInt("IDUSUARIO"));
                    reserva.setFechaInicio(rs.getDate("FECHA_INICIO"));
                    reserva.setFechaFin(rs.getDate("FECHA_FIN"));
                    reserva.setTotal(rs.getDouble("TOTAL"));
                    return reserva;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener reserva por ID: " + e.getMessage());
            throw e;
        }
        return null;
    }
}
