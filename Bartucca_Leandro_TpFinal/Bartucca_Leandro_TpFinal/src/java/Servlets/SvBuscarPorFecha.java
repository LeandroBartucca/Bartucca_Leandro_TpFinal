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

@WebServlet(name = "SvBuscarPorFecha", urlPatterns = {"/SvBuscarPorFecha"})
public class SvBuscarPorFecha extends HttpServlet {

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

        String fecha_busqueda = request.getParameter("fecha_busqueda");

        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");

        Date fechaCarga = null;
        try {
            fechaCarga = formatoFecha.parse(fecha_busqueda);

        } catch (ParseException ex) {
            ex.printStackTrace();

        }

        HttpSession miSesion = request.getSession();
        //Guardo el objeto en la sesion
        miSesion.setAttribute("fecha_carga", fechaCarga);

        response.sendRedirect("BuscarPorFecha.jsp");

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
