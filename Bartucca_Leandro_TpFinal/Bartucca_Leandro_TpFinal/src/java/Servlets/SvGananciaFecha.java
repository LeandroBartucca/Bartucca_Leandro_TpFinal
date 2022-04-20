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

@WebServlet(name = "SvGananciaFecha", urlPatterns = {"/SvGananciaFecha"})
public class SvGananciaFecha extends HttpServlet {

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

        String fechaRec = request.getParameter("fecha_ganancia");

        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");

        Date fecha_ganancia = null;
        try {
            fecha_ganancia = formatoFecha.parse(fechaRec);

        } catch (ParseException ex) {
            ex.printStackTrace();

        }

        HttpSession miSesion = request.getSession();
        //Guardo el objeto en la sesion
        miSesion.setAttribute("fecha_ganancia", fecha_ganancia);

        response.sendRedirect("GananciaPorFecha.jsp");

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
