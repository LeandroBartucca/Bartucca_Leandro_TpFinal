package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "SvBuscarPorUsuario", urlPatterns = {"/SvBuscarPorUsuario"})
public class SvBuscarPorUsuario extends HttpServlet {

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

        String nombre_usuario = request.getParameter("nombre_usuario");

        HttpSession miSesion = request.getSession();
        //Guardo el objeto en la sesion
        miSesion.setAttribute("nombre_usuario", nombre_usuario);

        response.sendRedirect("BuscarPorUsuario.jsp");

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
