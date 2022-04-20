<%@page import="Logica.Reserva"%>
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
        <title>Todas las reservas</title>
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
                        <h2 class="heading-section">Ver todas las reservas</h2>
                    </div>
                </div>

                <button type="button" onclick="location.href = 'Principal.jsp'" class="btn btn-dark" data-title="Volver" style="display_inline"> Regresar</button>
                <br>
                <br>

                <form name="formBuscarPorFecha" action="SvBuscarPorFecha" method="POST" style="display:inline">
                    <p>Buscar por fecha de carga:</p>
                    <input type="date" name="fecha_busqueda">
                    <button type="submit" class="btn btn-primary" data-title="BuscarPorFecha" style="display_inline"> Buscar</button>
                </form>

                <br>
                <br>

                <form name="formBuscarPorUsuario" action="SvBuscarPorUsuario" method="POST" style="display:inline">
                    <p>Buscar por usuario:</p>
                    <input type="text" style="width : 300px;" name="nombre_usuario" placeholder="Buscar por nombre de usuario">
                    <button type="submit" class="btn btn-primary" data-title="BuscarPorUsuario" style="display_inline"> Buscar</button>
                </form>

                <br>
                <br>

                <form name="formBuscarPorHuespedPeriodo" action="SvBuscarPorHuespedPeriodo" method="POST" style="display:inline">
                    <p>Buscar por huesped, en un periodo desde/hasta (fechas de carga):</p>
                    <input type="text" style="width : 150px;" name="nombre_huesped" placeholder="Nombre">
                    <input type="text" style="width : 150px;" name="apellido_huesped" placeholder="Apellido">
                    <input type="date" name="fecha_desde">
                    <input type="date" name="fecha_hasta">
                    <button type="submit" class="btn btn-primary" data-title="BuscarPorHuespedPeriodo" style="display_inline"> Buscar</button>
                </form>

                <br>
                <br>

                <div class="row">
                    <div class="col-md-12">
                        <div class="table-wrap">
                            <table class="table table-dark">
                                <thead>
                                    <tr class="bg-primary">
                                        <th>Habitacion</th>
                                        <th>Huesped</th>
                                        <th>Usuario</th>
                                        <th>Check in</th>
                                        <th>Check out</th>
                                        <th>Fecha de carga</th>
                                        <th>Cantidad de personas</th>
                                        <th>Cantidad de noches</th>
                                        <th>Precio</th>
                                        <th>Modificar</th>
                                        <th>Eliminar</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr class="bg-dark">

                                        <% Controladora control = (Controladora) miSesion.getAttribute("control");
                                            List<Reserva> listaReservas = control.getReservas();
                                            for (Reserva res : listaReservas) {

                                        %>

                                        <% String hab = res.getHabitacion().getNombre();%>
                                        <td><%=hab%></td>
                                        <% String hueN = res.getHuesped().getNombre();%>
                                        <% String hueA = res.getHuesped().getApellido();%> 
                                        <td><%=hueN + " " + hueA%></td>
                                        <% String usuario = res.getUsuario().getNombre_usuario();%>
                                        <td><%=usuario%></td>
                                        <%

                                            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
                                            String fecha_in = formatoFecha.format(res.getCheck_in());

                                        %>

                                        <td><%=fecha_in%></td>
                                        <%

                                            String fecha_out = formatoFecha.format(res.getCheck_out());

                                        %>

                                        <td><%=fecha_out%></td>
                                        <%

                                            String fecha_rsv = formatoFecha.format(res.getFecha_rsv());

                                        %>

                                        <td><%=fecha_rsv%></td>

                                        <% int cant_per = res.getCant_personas();%>
                                        <td><%=cant_per%></td>
                                        <% int cant_noch = res.getCant_noches();%>
                                        <td><%=cant_noch%></td>
                                        <% float precio = res.getPrecio_reserva();%>
                                        <td><%=precio%></td>


                                        <% long id = res.getId_reserva();%>

                                        <td>

                                            <form name="formModificar" action="SvModificarRes" method="POST" style="display:inline">
                                                <input type="hidden" name="id_res" value="<%=id%>">
                                                <button type="submit" class="btn btn-primary" data-title="Modificar" style="display_inline"> Modificar</button>
                                            </form>
                                        </td>

                                        <td>
                                            <form name="formEliminar" action="SvEliminarRes" method="POST" style="display:inline">
                                                <input type="hidden" name="id_res" value="<%=id%>">
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


