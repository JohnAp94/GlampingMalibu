package Controlador;

import Modelo.Alojamiento;
import Modelo.DAOAlojamiento;
import Modelo.DAORESERVA;
import Modelo.Reserva;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ReservaServlet", urlPatterns = {"/ReservaServlet"})
public class ReservaServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "reservar":
                    try {
                        mostrarFormularioReserva(request, response);
                    } catch (Exception e) {
                        request.setAttribute("errorMessage", "Error al cargar el formulario de reserva: " + e.getMessage());
                        request.getRequestDispatcher("error.jsp").forward(request, response);
                    }
                    break;
                case "agregar":
                    try {
                        reservarAlojamiento(request, response);
                    } catch (Exception e) {
                        request.setAttribute("errorMessage", "Error al realizar la reserva: " + e.getMessage());
                        request.getRequestDispatcher("error.jsp").forward(request, response);
                    }
            }
        }
    }

    private void mostrarFormularioReserva(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException, SQLException {
        int idAlojamiento = Integer.parseInt(request.getParameter("idAlojamiento"));
        System.out.println(idAlojamiento);

        DAOAlojamiento daoAlojamiento = new DAOAlojamiento();
        Alojamiento alojamiento = daoAlojamiento.obtenerAlojamientoPorId(idAlojamiento);

        request.setAttribute("alojamiento", alojamiento);
        request.getRequestDispatcher("reserva.jsp").forward(request, response);
    }
    
    private void reservarAlojamiento(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // Obtiene los parámetros de la reserva
        int idAlojamiento = Integer.parseInt(request.getParameter("idAlojamiento"));
        int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
        String fechaInicioStr = request.getParameter("fechaInicio");
        String fechaFinStr = request.getParameter("fechaFin");
        String precioStr = request.getParameter("precioPorNoche");
        double precioPorNoche = Double.parseDouble(precioStr);
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaInicio = formatoFecha.parse(fechaInicioStr);
        Date fechaFin = formatoFecha.parse(fechaFinStr);
        
        long diffInMillies = Math.abs(fechaFin.getTime() - fechaInicio.getTime());
        long diff = diffInMillies / (24 * 60 * 60 * 1000);
        double total = precioPorNoche * diff;

        Reserva reserva = new Reserva();
        reserva.setIdAlojamiento(idAlojamiento);
        reserva.setIdUsuario(idUsuario);
        reserva.setFechaInicio(fechaInicio);
        reserva.setFechaFin(fechaFin);
        reserva.setTotal(total);

        DAORESERVA daoReserva = new DAORESERVA();
        boolean reservaExitosa = daoReserva.agregarReserva(reserva);

        if (reservaExitosa) {
            request.setAttribute("mensaje", "Reserva realizada con éxito");
            request.getRequestDispatcher("ReservaExitosa.jsp").forward(request, response);
        } else {
            request.setAttribute("errorMessage", "No se pudo realizar la reserva");
            request.getRequestDispatcher("error.jsp").forward(request, response);
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

}
