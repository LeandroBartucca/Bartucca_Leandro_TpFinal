package Servlets;

import Logica.Controladora;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SvEliminarHab", urlPatterns = {"/SvEliminarHab"})
public class SvEliminarHab extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        int id_hab = Integer.parseInt(request.getParameter("id_hab"));

        Controladora control = new Controladora();

        control.borrarHabitacion(id_hab);

        //Actualizo la lista para que se actualice la tabla en el momento
        request.getSession().setAttribute("listaHabitaciones", control.getHabitaciones());

        response.sendRedirect("VerHabitaciones.jsp");

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
