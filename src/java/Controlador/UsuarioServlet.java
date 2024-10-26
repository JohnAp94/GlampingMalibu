
package Controlador;

import Modelo.DAOUSUARIO;
import Modelo.usuario;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "UsuarioServlet", urlPatterns = {"/UsuarioServlet"})
public class UsuarioServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if(accion != null && accion.equals("listar")){
            listarUsuarios(request, response);
        }else{
            response.sendRedirect("/Admin/admin.jsp");
        }
    }
    
    private void listarUsuarios(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        DAOUSUARIO daoUsuario = new DAOUSUARIO();
        try{
            List<usuario> listaUsuarios = daoUsuario.obtenerUsuarios();
            request.setAttribute("listaUsuarios", listaUsuarios);
            request.getRequestDispatcher("listaUsuarios.jsp").forward(request, response);
        }catch(Exception e){
            e.printStackTrace();
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
    }

}
