package Servlets;

import Logica.Controladora;
import Logica.Habitacion;
import Logica.Huesped;
import Logica.Reserva;
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

@WebServlet(name = "SvModificarRes", urlPatterns = {"/SvModificarRes"})
public class SvModificarRes extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        int id_res = Integer.parseInt(request.getParameter("id_res"));

        String id_habitacion = request.getParameter("selectHabitacion");
        String id_huesped = request.getParameter("selectHuesped");
        String cant_personas = request.getParameter("cant_per");
        String check_in = request.getParameter("check_in");
        String check_out = request.getParameter("check_out");
        String cant_per = request.getParameter("cant_per");

        Controladora control = new Controladora();

        int id_hab = Integer.parseInt(id_habitacion);
        Habitacion hab = control.buscarHabitacion(id_hab);

        int id_hue = Integer.parseInt(id_huesped);
        Huesped hue = control.buscarHuesped(id_hue);

        //Traigo el usuario de la sesion
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

        //Obtengo la cantidad de noches
        int milisecondsByDay = 86400000;

        int cant_noc = (int) ((check_out2.getTime() - check_in2.getTime()) / milisecondsByDay);

        //Obtengo el precio total
        float precio_aux = hab.getPrecio_noche();

        float precio_rsv = cant_noc * precio_aux;

        //Asigno 2 booleanos desde mis funciones para verificar de la controladora
        boolean autorizarPersonas = control.verificarCant_personas(cant_personas, id_habitacion);

        boolean autorizarDisponibilidad = control.verificarFechas(check_in, check_out, id_habitacion);

        //Si pasa ambas validaciones modifico y sino no
        if (autorizarPersonas == true && autorizarDisponibilidad == true) {

            Reserva res = control.buscarReserva(id_res);

            res.setHabitacion(hab);
            res.setHuesped(hue);
            res.setUsuario(usuario);
            res.setCheck_in(check_in2);
            res.setCheck_out(check_out2);
            res.setFecha_rsv(fechaHoy2);

            int cant_pers = Integer.parseInt(cant_per);
            res.setCant_personas(cant_pers);

            res.setCant_noches(cant_noc);
            res.setPrecio_reserva(precio_rsv);

            control.modificarReserva(res);

            response.sendRedirect("VerReservas.jsp");

        } else {
            response.sendRedirect("ModificarReserva.jsp");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        int id_res = Integer.parseInt(request.getParameter("id_res"));

        Controladora control = new Controladora();

        Reserva res = control.buscarReserva(id_res);

        HttpSession miSesion = request.getSession();
        miSesion.setAttribute("reserva", res);
        response.sendRedirect("ModificarRes.jsp");

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
