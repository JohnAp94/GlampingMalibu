package Controlador;

import Modelo.Reserva;
import Modelo.DAORESERVA;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ReservaServlet", urlPatterns = {"/ReservaServlet"})
public class ReservacionesServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String accion = request.getParameter("accion");
        DAORESERVA daoReserva = new DAORESERVA();

        try {
            switch (accion) {
                case "listar": // Muestra la lista de reservaciones
                    listarReservas(request, response, daoReserva);
                    break;

                // Puedes agregar más casos según las necesidades de tu aplicación
                default:
                    request.setAttribute("msje", "Acción no válida.");
                    request.getRequestDispatcher("error.jsp").forward(request, response);
            }
        } catch (Exception e) {
            System.err.println("Error en ReservaServlet: " + e.getMessage());
            request.setAttribute("msje", "Error en el procesamiento: " + e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    private void listarReservas(HttpServletRequest request, HttpServletResponse response, DAORESERVA daoReserva)
            throws ServletException, IOException {
        try {
            List<Reserva> listaReservas = daoReserva.listarReservasConDetalles();
            request.setAttribute("listaReservas", listaReservas);
            request.getRequestDispatcher("listarReservas.jsp").forward(request, response);
        } catch (Exception e) {
            throw new ServletException("Error al listar reservas: " + e.getMessage());
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
        return "ReservaServlet";
    }
}
