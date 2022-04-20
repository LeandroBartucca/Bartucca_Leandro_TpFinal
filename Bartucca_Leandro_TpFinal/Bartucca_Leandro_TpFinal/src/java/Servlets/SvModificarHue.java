package Servlets;

import Logica.Controladora;
import Logica.Huesped;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "SvModificarHue", urlPatterns = {"/SvModificarHue"})
public class SvModificarHue extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        int id = Integer.parseInt(request.getParameter("id_hue"));

        String dni = request.getParameter("dni");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String fechanac = request.getParameter("fechanac");
        String direccion = request.getParameter("direccion");
        String profesion = request.getParameter("profesion");

        Controladora control = new Controladora();
        Huesped hue = control.buscarHuesped(id);

        hue.setDni(dni);
        hue.setNombre(nombre);
        hue.setApellido(apellido);

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaAux = null;
        try {
            fechaAux = df.parse(fechanac);

        } catch (ParseException ex) {
            ex.printStackTrace();

        }

        hue.setFecha_nac(fechaAux);

        hue.setDireccion(direccion);
        hue.setProfesion(profesion);

        control.modificarHuesped(hue);

        //Actualizo la lista de huespedes
        request.getSession().setAttribute("listaHuespedes", control.getHuespedes());
        response.sendRedirect("VerHuespedes.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        int id_hue = Integer.parseInt(request.getParameter("id_hue"));

        Controladora control = new Controladora();

        Huesped hue = control.buscarHuesped(id_hue);

        HttpSession miSesion = request.getSession();
        miSesion.setAttribute("huesped", hue);
        response.sendRedirect("ModificarHue.jsp");

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
