package Servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "SvGananciaRango", urlPatterns = {"/SvGananciaRango"})
public class SvGananciaRango extends HttpServlet {

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

        String fechadesde = request.getParameter("fecha_desde");
        String fechahasta = request.getParameter("fecha_hasta");

        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");

        Date fecha_desde = null;
        try {
            fecha_desde = formatoFecha.parse(fechadesde);

        } catch (ParseException ex) {
            ex.printStackTrace();

        }

        Date fecha_hasta = null;
        try {
            fecha_hasta = formatoFecha.parse(fechahasta);

        } catch (ParseException ex) {
            ex.printStackTrace();

        }

        HttpSession miSesion = request.getSession();
        //Guardo el objeto en la sesion
        miSesion.setAttribute("fecha_desde", fecha_desde);
        miSesion.setAttribute("fecha_hasta", fecha_hasta);

        response.sendRedirect("GananciaRango.jsp");

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
