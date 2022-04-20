package Servlets;

import Logica.Controladora;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SvCargarEmpleado", urlPatterns = {"/SvCargarEmpleado"})
public class SvCargarEmpleado extends HttpServlet {

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
        String cargo = request.getParameter("cargo");
        String nombre_usuario = request.getParameter("nombre_usuario");
        String contrasenia = request.getParameter("contrasenia");

        Controladora control = new Controladora();

        control.crearEmpleado(dni, nombre, apellido, fechanac, direccion, cargo, nombre_usuario, contrasenia);

        response.sendRedirect("Principal.jsp");

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
