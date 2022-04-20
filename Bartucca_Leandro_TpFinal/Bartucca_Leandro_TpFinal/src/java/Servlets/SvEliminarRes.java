package Servlets;

import Logica.Controladora;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SvEliminarRes", urlPatterns = {"/SvEliminarRes"})
public class SvEliminarRes extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

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

        int id_res = Integer.parseInt(request.getParameter("id_res"));

        Controladora control = new Controladora();

        control.borrarReserva(id_res);

        //Actualizo la lista para que se actualice la tabla en el momento
        request.getSession().setAttribute("listaReservas", control.getReservas());

        response.sendRedirect("VerReservas.jsp");

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
