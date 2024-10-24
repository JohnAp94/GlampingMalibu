
package Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

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
                usu.setCedula(rs.getInt("CEDULA"));
                usu.setNombre(rs.getString("NOMBRE"));
                usu.setApellido(rs.getString("APELLIDO"));
                usu.setGenero(rs.getInt("GENERO"));
                usu.setEmail(rs.getString("EMAIL"));
            }
        }catch(Exception e){
            System.out.println("Error"+ e.getMessage());
        }finally{
            if (rs !=null && rs.isClosed() == false){
                cn.close();
            }
            cn = null;
        }
        return usu;
    }
}
