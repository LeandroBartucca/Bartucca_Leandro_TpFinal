package Servlets;

import Logica.Controladora;
import Logica.Habitacion;
import java.io.IOException;
import static java.lang.Float.parseFloat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "SvModificarHab", urlPatterns = {"/SvModificarHab"})
public class SvModificarHab extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        int id_hab = Integer.parseInt(request.getParameter("id_hab"));
        String num_hab = request.getParameter("num_hab");
        String piso = request.getParameter("piso");
        String nombre = request.getParameter("nombre");
        String tipo = request.getParameter("tipo");
        float precio_noche = parseFloat(request.getParameter("precio_noche"));

        Controladora control = new Controladora();
        Habitacion hab = control.buscarHabitacion(id_hab);

        hab.setNum_hab(num_hab);
        hab.setPiso(piso);
        hab.setNombre(nombre);
        hab.setTipo(tipo);
        hab.setPrecio_noche(precio_noche);

        control.modificarHabitacion(hab);

        //Actualizo la lista de habitaciones
        request.getSession().setAttribute("listaHabitaciones", control.getHabitaciones());
        response.sendRedirect("VerHabitaciones.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        int id_hab = Integer.parseInt(request.getParameter("id_hab"));

        Controladora control = new Controladora();

        Habitacion hab = control.buscarHabitacion(id_hab);

        HttpSession miSesion = request.getSession();
        miSesion.setAttribute("habitacion", hab);
        response.sendRedirect("ModificarHab.jsp");

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
