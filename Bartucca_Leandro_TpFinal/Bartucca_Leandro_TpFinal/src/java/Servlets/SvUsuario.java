package Servlets;

import Logica.Controladora;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "SvUsuario", urlPatterns = {"/SvUsuario"})
public class SvUsuario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String usuario = request.getParameter("user");
        String contra = request.getParameter("pass");

        Controladora control = new Controladora();

        Long id_usuario = control.verificarUsuario(usuario, contra);

        if (id_usuario != null) {
            //Obtengo la sesión y le asigno el usuario para validar
            //Tambien guardo el id que me sirve para el usuario a las reservas
            HttpSession miSesion = request.getSession(true);
            miSesion.setAttribute("usuario", usuario);
            miSesion.setAttribute("id_usuario", id_usuario);
            miSesion.setAttribute("control", control);

            response.sendRedirect("Principal.jsp");

        } else {

            response.sendRedirect("Login.jsp");

        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
