package Servlets;

import Logica.Controladora;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SvCargarHuesped", urlPatterns = {"/SvCargarHuesped"})
public class SvCargarHuesped extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        String dni = request.getParameter("dni");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String fechanac = request.getParameter("fechanac");
        String direccion = request.getParameter("direccion");
        String profesion = request.getParameter("profesion");

        Controladora control = new Controladora();

        control.crearHuesped(dni, nombre, apellido, fechanac, direccion, profesion);

        response.sendRedirect("Principal.jsp");

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
