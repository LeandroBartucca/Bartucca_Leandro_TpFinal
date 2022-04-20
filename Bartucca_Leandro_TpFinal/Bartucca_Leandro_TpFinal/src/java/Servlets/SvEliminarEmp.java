package Servlets;

import Logica.Controladora;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SvEliminarEmp", urlPatterns = {"/SvEliminarEmp"})
public class SvEliminarEmp extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        int id_emp = Integer.parseInt(request.getParameter("id_emp"));

        Controladora control = new Controladora();

        control.borrarEmpleado(id_emp);

        //Actualizo la lista para que se actualice la tabla en el momento
        request.getSession().setAttribute("listaEmpleados", control.getEmpleados());

        response.sendRedirect("VerEmpleados.jsp");

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
