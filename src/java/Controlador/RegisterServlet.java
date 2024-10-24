
package Controlador;

import Modelo.DAOUSUARIO;
import Modelo.conexion;
import Modelo.usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "RegisterServlet", urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String accion = request.getParameter("accion");
        try{
            if (accion != null){
                switch(accion){
                    case "registrar":
                        registrar(request, response);
                        break;
                }
            }else{
                response.sendRedirect("login.jsp");
            }
        }catch(Exception e){
            try{
                this.getServletConfig().getServletContext().getRequestDispatcher("/mensajeError.jsp").forward(request, response);
            }catch(Exception ex){
                System.out.println("Error"+ e.getMessage());
            }
        }
    }
    
    private void registrar (HttpServletRequest request, HttpServletResponse response) throws Exception{
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String lastname = request.getParameter("lastname");
        int genero = Integer.parseInt(request.getParameter("genero"));
        int cedula = Integer.parseInt(request.getParameter("cedula"));
        String email = request.getParameter("email");
        
        try {
            conexion cn = new conexion();
            Connection connection = cn.conectar();
            String sql = "INSERT INTO usuario (NOMBREUSUARIO, CLAVE, NOMBRE, APELLIDO, GENERO, CEDULA, EMAIL, IDCARGO) VALUES (?, ?, ?, ?, ?, ?, ?, 2)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);
            statement.setString(3, name);
            statement.setString(4, lastname);
            statement.setInt(5, genero);
            statement.setInt(6, cedula);
            statement.setString(7, email);
            int rowsInserted = statement.executeUpdate();
            if(rowsInserted > 0){
                request.getRequestDispatcher("RegExitoso.jsp").forward(request, response);
            }else{
                request.setAttribute("msje", "No se pudo registrar el usuario");
                request.getRequestDispatcher("register.jsp").forward(request, response);
            }
            statement.close();
            connection.close();
        }catch(SQLException e){
            request.setAttribute("msje", "Error en la base de datos: " + e.getMessage());
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
