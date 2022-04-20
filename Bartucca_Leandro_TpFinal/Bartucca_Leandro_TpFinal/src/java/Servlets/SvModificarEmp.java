package Servlets;

import Logica.Controladora;
import Logica.Empleado;
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

@WebServlet(name = "SvModificarEmp", urlPatterns = {"/SvModificarEmp"})
public class SvModificarEmp extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        int id = Integer.parseInt(request.getParameter("id_emp"));

        String dni = request.getParameter("dni");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String fechanac = request.getParameter("fechanac");
        String direccion = request.getParameter("direccion");
        String cargo = request.getParameter("cargo");

        Controladora control = new Controladora();
        Empleado emp = control.buscarEmpleado(id);

        emp.setDni(dni);
        emp.setNombre(nombre);
        emp.setApellido(apellido);

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaAux = null;
        try {
            fechaAux = df.parse(fechanac);

        } catch (ParseException ex) {
            ex.printStackTrace();

        }

        emp.setFecha_nac(fechaAux);

        emp.setDireccion(direccion);
        emp.setCargo(cargo);

        control.modificarEmpleado(emp);

        //Actualizo la lista de empleados
        request.getSession().setAttribute("listaEmpleados", control.getEmpleados());
        response.sendRedirect("VerEmpleados.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        int id_emp = Integer.parseInt(request.getParameter("id_emp"));

        Controladora control = new Controladora();

        Empleado emp = control.buscarEmpleado(id_emp);

        HttpSession miSesion = request.getSession();
        miSesion.setAttribute("empleado", emp);
        response.sendRedirect("ModificarEmp.jsp");

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
