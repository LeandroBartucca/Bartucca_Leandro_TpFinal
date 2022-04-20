<%@page import="java.text.SimpleDateFormat"%>
<%@page import="Logica.Empleado"%>
<%@page import="java.util.Date"%>
<%@page import="Logica.Huesped"%>
<%@page import="Logica.Habitacion"%>
<%@page import="java.util.List"%>
<%@page import="Logica.Controladora"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="es">
    <head>
        <title>Ver Empleados</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,700' rel='stylesheet' type='text/css'>

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

        <link rel="stylesheet" href="css2/style.css">

    </head>
    <body>

        <% //Compruebo que exista un usuario en la sesion y sino redirecciono al login
            HttpSession miSesion = request.getSession();

            String usu = (String) miSesion.getAttribute("usuario");
            if (usu == null) {
                response.sendRedirect("Login.jsp");
            } else {

        %>

        <section class="ftco-section">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-md-6 text-center mb-5">
                        <h2 class="heading-section">Empleados</h2>
                    </div>
                </div>

                <button type="button" onclick="location.href = 'Principal.jsp'" class="btn btn-dark" data-title="Volver" style="display_inline"> Regresar</button>
                <br>
                <br>

                <div class="row">
                    <div class="col-md-12">
                        <div class="table-wrap">
                            <table class="table table-dark">
                                <thead>
                                    <tr class="bg-primary">
                                        <th>Dni</th>
                                        <th>Nombre</th>
                                        <th>Apellido</th>
                                        <th>Fecha de nacimiento</th>
                                        <th>Direccion</th>
                                        <th>Cargo</th>
                                        <th>Usuario</th>
                                        <th>Modificar</th>
                                        <th>Eliminar</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr class="bg-dark">

                                        <% Controladora control = (Controladora) miSesion.getAttribute("control");
                                            List<Empleado> listaEmpleados = control.getEmpleados();
                                            for (Empleado emp : listaEmpleados) {

                                        %>

                                        <% String dni = emp.getDni();%>
                                        <td><%=dni%></td>
                                        <% String nombre = emp.getNombre();%>    
                                        <td><%=nombre%></td>
                                        <% String apellido = emp.getApellido();%>
                                        <td><%=apellido%></td>
                                        <%

                                            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
                                            String fechaAux = formatoFecha.format(emp.getFecha_nac());

                                        %>

                                        <td><%=fechaAux%></td>
                                        <% String direccion = emp.getDireccion();%>
                                        <td><%=direccion%></td>
                                        <% String cargo = emp.getCargo();%>
                                        <td><%=cargo%></td>
                                        <% String usuario = emp.getUsuario().getNombre_usuario();%>
                                        <td><%=usuario%></td>

                                        <% int id = emp.getId();%>

                                        <td>

                                            <form name="formModificar" action="SvModificarEmp" method="POST" style="display:inline">
                                                <input type="hidden" name="id_emp" value="<%=id%>">
                                                <button type="submit" class="btn btn-primary" data-title="Modificar" style="display_inline"> Modificar</button>
                                            </form>
                                        </td>

                                        <td>
                                            <form name="formEliminar" action="SvEliminarEmp" method="POST" style="display:inline">
                                                <input type="hidden" name="id_emp" value="<%=id%>">
                                                <button type="submit" class="btn btn-danger btn-xs" data-title="Eliminar" style="display_inline"> Eliminar</button>
                                            </form>
                                        </td>
                                    </tr>


                                    <%  }  %>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <script src="js2/jquery.min.js"></script>
        <script src="js2/popper.js"></script>
        <script src="js2/bootstrap.min.js"></script>
        <script src="js2/main.js"></script>

        <%            }
        %>

    </body>
</html>


