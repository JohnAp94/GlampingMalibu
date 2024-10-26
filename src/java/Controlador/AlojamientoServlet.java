package Controlador;

import Modelo.DAOAlojamiento;
import Modelo.Alojamiento;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AlojamientoServlet", urlPatterns = {"/AlojamientoServlet"})
public class AlojamientoServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "listar":
                    listarAlojamientos(request, response);
                    break;
                default:
                    response.sendRedirect("error.jsp");
                    break;
            }
        } else {
            response.sendRedirect("error.jsp");
        }
    }

    private void listarAlojamientos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        DAOAlojamiento dao = new DAOAlojamiento();
        try {
            List<Alojamiento> listaAlojamientos = dao.listarAlojamientos();
            request.setAttribute("listaAlojamientos", listaAlojamientos);
            request.getRequestDispatcher("/Cliente/cliente.jsp").forward(request, response);
        } catch (Exception e) {
            System.out.println("Llamando a listarAlojamientos");
            List<Alojamiento> listaAlojamientos = dao.listarAlojamientos();
            System.out.println("Alojamientos recuperados: " + listaAlojamientos.size());
            System.out.println("Error al listar alojamientos: " + e.getMessage());
            request.setAttribute("errorMessage", "Error al listar alojamientos: " + e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AlojamientoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AlojamientoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Alojamiento servlet";
    }
}
