package Servlets;

import Logica.Controladora;
import Logica.Habitacion;
import Logica.Huesped;
import Logica.Usuario;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "SvCargarReserva", urlPatterns = {"/SvCargarReserva"})
public class SvCargarReserva extends HttpServlet {

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

        String id_habitacion = request.getParameter("selectHabitacion");
        String id_huesped = request.getParameter("selectHuesped");
        String cant_personas = request.getParameter("cant_per");
        String check_in = request.getParameter("check_in");
        String check_out = request.getParameter("check_out");

        Controladora control = new Controladora();

        int id_hab = Integer.parseInt(id_habitacion);
        Habitacion hab = control.buscarHabitacion(id_hab);

        int id = Integer.parseInt(id_huesped);
        Huesped hue = control.buscarHuesped(id);

        //Obtengo el usuario de la sesion
        HttpSession miSesion = request.getSession();
        Long id_usuario = (Long) miSesion.getAttribute("id_usuario");

        Usuario usuario = control.buscarUsuario(id_usuario.intValue());

        //Obtengo la fecha de hoy
        Calendar c1 = Calendar.getInstance();
        Date fechaHoy = c1.getTime();

        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");

        String fecha_aux = formatoFecha.format(fechaHoy);

        Date fechaHoy2 = null;
        try {
            fechaHoy2 = formatoFecha.parse(fecha_aux);

        } catch (ParseException ex) {
            ex.printStackTrace();

        }

        Date check_in2 = null;
        try {
            check_in2 = formatoFecha.parse(check_in);

        } catch (ParseException ex) {
            ex.printStackTrace();

        }

        Date check_out2 = null;
        try {
            check_out2 = formatoFecha.parse(check_out);

        } catch (ParseException ex) {
            ex.printStackTrace();

        }

        //Linea 95 a 98 obtengo la cantidad de noches de la reserva
        int milisecondsByDay = 86400000;

        int cant_noc = (int) ((check_out2.getTime() - check_in2.getTime()) / milisecondsByDay);

        //Linea 101 a 103 obtengo el precio total
        float precio_aux = hab.getPrecio_noche();

        float precio_rsv = cant_noc * precio_aux;

        //Obtengo ambos booleanos de mis funciones creadas en la controladora
        boolean autorizarPersonas = control.verificarCant_personas(cant_personas, id_habitacion);

        boolean autorizarDisponibilidad = control.verificarFechas(check_in, check_out, id_habitacion);

        //Si pasa ambas comprobaciones carga la reserva y sino no
        if (autorizarPersonas == true && autorizarDisponibilidad == true) {

            control.crearReserva(hab, hue, usuario, check_in2, check_out2, fechaHoy2, cant_personas, cant_noc, precio_rsv);

            response.sendRedirect("Principal.jsp");

        } else {
            response.sendRedirect("CargarReserva.jsp");
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
