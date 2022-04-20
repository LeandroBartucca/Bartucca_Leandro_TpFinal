package Servlets;

import Logica.Controladora;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SvEliminarHue", urlPatterns = {"/SvEliminarHue"})
public class SvEliminarHue extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        int id_hue = Integer.parseInt(request.getParameter("id_hue"));

        Controladora control = new Controladora();

        control.borrarHuesped(id_hue);

        //Actualizo la lista para que se actualice la tabla en el momento
        request.getSession().setAttribute("listaHuespedes", control.getHuespedes());

        response.sendRedirect("VerHuespedes.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
