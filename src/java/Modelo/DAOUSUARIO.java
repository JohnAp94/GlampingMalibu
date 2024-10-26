
package Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;

public class DAOUSUARIO extends conexion{
    public usuario identificar(usuario user) throws Exception{
        usuario usu = null;
        conexion con;
        Connection cn = null;
        Statement st = null;
        ResultSet rs = null;
        String sql = "SELECT U.IDUSUARIO, U.NOMBREUSUARIO, U.CLAVE, U.CEDULA, U.NOMBRE, U.APELLIDO, "
                + "U.GENERO, U.EMAIL, C.NOMBRECARGO FROM USUARIO U INNER JOIN CARGO C ON "
                + "U.IDCARGO = C.IDCARGO WHERE U.NOMBREUSUARIO = '"+ user.getNombreUsuario()+"' "
                + "AND U.CLAVE = '"+user.getClave()+"'";
        con = new conexion();
        try{
            cn = con.conectar();
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            if (rs.next()) {
                usu = new usuario();
                usu.setId_usuario(rs.getInt("IDUSUARIO"));
                usu.setNombreUsuario(rs.getString("NOMBREUSUARIO"));
                usu.setCargo(new cargo());
                usu.getCargo().setNombreCargo(rs.getString("NOMBRECARGO"));
                usu.setClave(rs.getString("CLAVE"));
                usu.setCedula(rs.getLong("CEDULA"));
                usu.setNombre(rs.getString("NOMBRE"));
                usu.setApellido(rs.getString("APELLIDO"));
                usu.setGenero(rs.getInt("GENERO"));
                usu.setEmail(rs.getString("EMAIL"));
            }
        }catch(Exception e){
            System.out.println("Error"+ e.getMessage());
        }finally{
            if(rs != null && !rs.isClosed()){
                rs.close();
            }
            if(st != null && !st.isClosed()){
                st.close();
            }
            if(cn != null && !cn.isClosed()){
                cn.close();
            }
        }
        return usu;
    }
    
    public List<usuario> obtenerUsuarios(){
        List<usuario> lista = new ArrayList<>();
        try {
            Connection cn = this.conectar();
            String sql = "SELECT u.*, c.NOMBRECARGO FROM usuario u " +
                     "INNER JOIN cargo c ON u.IDCARGO = c.IDCARGO";
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                usuario usu = new usuario();
                usu.setId_usuario(rs.getInt("IDUSUARIO"));
                usu.setNombreUsuario(rs.getString("NOMBREUSUARIO"));
                usu.setCedula(rs.getLong("CEDULA"));
                usu.setNombre(rs.getString("NOMBRE"));
                usu.setApellido(rs.getString("APELLIDO"));
                usu.setGenero(rs.getInt("GENERO"));
                usu.setEmail(rs.getString("EMAIL"));
                cargo cargo = new cargo();
                cargo.setNombreCargo(rs.getString("NOMBRECARGO"));
                usu.setCargo(cargo);
                lista.add(usu);
            }
            rs.close();
            ps.close();
            cn.close();
        }catch(Exception e){
            System.out.println("Error al obtener usuarios: " + e.getMessage());
        }
        System.out.println("Total usuarios obtenidos: " + lista.size());
        return lista;
    }
}
