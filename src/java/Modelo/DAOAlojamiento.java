
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOAlojamiento extends conexion{
    
    public List<Alojamiento> listarAlojamientos() throws SQLException {
        List<Alojamiento> lista = new ArrayList<>();
        Connection cn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            cn = this.conectar();
            String sql = "SELECT * FROM alojamiento";
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Alojamiento alojamiento = new Alojamiento();
                alojamiento.setIdAlojamiento(rs.getInt("IDALOJAMIENTO"));
                alojamiento.setNombre(rs.getString("NOMBRE"));
                alojamiento.setDescripcion(rs.getString("DESCRIPCION"));
                alojamiento.setCapacidad(rs.getInt("CAPACIDAD"));
                alojamiento.setPrecio(rs.getDouble("PRECIO"));
                alojamiento.setRutaFoto(rs.getString("RUTA_FOTO"));
                lista.add(alojamiento);
            }
            System.out.println("Alojamientos recuperados: " + lista.size());
        } catch (SQLException e) {
            System.out.println("Error al listar alojamientos: " + e.getMessage());
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
        return lista;
    }

    
    public boolean agregarAlojamiento(Alojamiento alojamiento) throws SQLException {
        String sql = "INSERT INTO alojamiento (nombre, descripcion, precio, ruta_foto) VALUES (?, ?, ?, ?)";
        try (Connection cn = this.conectar();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            
            ps.setString(1, alojamiento.getNombre());
            ps.setString(2, alojamiento.getDescripcion());
            ps.setDouble(3, alojamiento.getPrecio());
            ps.setString(4, alojamiento.getRutaFoto());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al agregar alojamiento: " + e.getMessage());
            return false;
        }
    }

    public boolean editarAlojamiento(Alojamiento alojamiento) throws SQLException {
        String sql = "UPDATE alojamiento SET NOMBRE = ?, DESCRIPCION = ?, PRECIO = ?, RUTA_FOTO = ? WHERE IDALOJAMIENTO = ?";
        try (Connection cn = this.conectar();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setString(1, alojamiento.getNombre());
            ps.setString(2, alojamiento.getDescripcion());
            ps.setDouble(3, alojamiento.getPrecio());
            ps.setString(4, alojamiento.getRutaFoto());
            ps.setInt(5, alojamiento.getIdAlojamiento());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al editar alojamiento: " + e.getMessage());
            return false;
        }
    }


    public boolean eliminarAlojamiento(int idAlojamiento) throws SQLException {
        String sql = "DELETE FROM alojamiento WHERE IDALOJAMIENTO = ?";
        try (Connection cn = this.conectar();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            
            ps.setInt(1, idAlojamiento);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar alojamiento: " + e.getMessage());
            return false;
        }
    }
    
    public Alojamiento obtenerAlojamientoPorId(int idAlojamiento) throws SQLException {
        Alojamiento alojamiento = null;
        String sql = "SELECT * FROM alojamiento WHERE IDALOJAMIENTO = ?";
        try (Connection cn = this.conectar();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setInt(1, idAlojamiento);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    alojamiento = new Alojamiento();
                    alojamiento.setIdAlojamiento(rs.getInt("IDALOJAMIENTO"));
                    alojamiento.setNombre(rs.getString("NOMBRE"));
                    alojamiento.setDescripcion(rs.getString("DESCRIPCION"));
                    alojamiento.setPrecio(rs.getDouble("PRECIO"));
                    alojamiento.setRutaFoto(rs.getString("RUTA_FOTO"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener alojamiento por ID: " + e.getMessage());
        }
        System.out.println(alojamiento);
        return alojamiento;
    }

    
}
