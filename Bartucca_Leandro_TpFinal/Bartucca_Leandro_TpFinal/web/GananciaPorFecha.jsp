<%@page import="java.text.ParseException"%>
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
        <title>Ganancia por fecha</title>
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
                        <h2 class="heading-section">Ver la ganancia por fecha</h2>
                    </div>
                </div>

                <button type="button" onclick="location.href = 'Ganancias.jsp'" class="btn btn-dark" data-title="Volver" style="display_inline"> Regresar</button>
                <br>
                <br>

                <form name="formGananciaFecha" action="SvGananciaFecha" method="POST" style="display:inline">
                    <p>Buscar por fecha:</p>
                    <input type="date" name="fecha_ganancia">
                    <button type="submit" class="btn btn-primary" data-title="fecha_recaudacion" style="display_inline"> Buscar</button>
                </form>

                <br>
                <br>

                <% Controladora control = (Controladora) miSesion.getAttribute("control");
                    Date fecha_recaudacion = (Date) miSesion.getAttribute("fecha_ganancia");

                    //Traigo mi nueva lista segun la busqueda
                    List<Reserva> listaReservas = control.getReservasPorFecha(fecha_recaudacion);

                    float acumulador = 0;

                    for (Reserva res : listaReservas) {

                        acumulador = acumulador + res.getPrecio_reserva();

                    }

                    String ganancia = String.valueOf(acumulador);

                %>

                <p>La ganancia de esta fecha es de: <%=ganancia%> </p>      


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


