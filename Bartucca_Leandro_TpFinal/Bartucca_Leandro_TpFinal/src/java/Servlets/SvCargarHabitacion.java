package Servlets;

import Logica.Controladora;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SvCargarHabitacion", urlPatterns = {"/SvCargarHabitacion"})
public class SvCargarHabitacion extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        String num_hab = request.getParameter("num_hab");
        String piso = request.getParameter("piso");
        String nombre = request.getParameter("nombre");
        String tipo = request.getParameter("tipo");
        String precio_noche = request.getParameter("precio_noche");

        Controladora control = new Controladora();

        control.crearHabitacion(num_hab, piso, nombre, tipo, precio_noche);

        response.sendRedirect("Principal.jsp");

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
