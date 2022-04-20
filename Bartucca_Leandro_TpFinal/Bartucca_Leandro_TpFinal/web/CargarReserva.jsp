<%@page import="Logica.Huesped"%>
<%@page import="Logica.Habitacion"%>
<%@page import="java.util.List"%>
<%@page import="Logica.Controladora"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Cargar Reserva</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/fontawesome.min.css">
        <link rel="stylesheet" href="css/style.css">
        <link href="https://fonts.googleapis.com/css?family=Lobster|Lobster+Two|Noto+Serif" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
    </head>



    <body>

        <% //Compruebo que exista un usuario en la sesion y sino redirecciono al login
            HttpSession miSesion = request.getSession();

            String usu = (String) miSesion.getAttribute("usuario");
            if (usu == null) {
                response.sendRedirect("Login.jsp");
            } else {

        %>

        <div class="contact main-font-family text-center">
            <div class="container">
                <h2 id="contact">Cargar Reserva</h2>
                <div class="row">
                    <div class="col-6">
                        <div class="contact-form">
                            <form action="SvCargarReserva" method="POST">


                                <select class="selectbonito" name="selectHabitacion">

                                    <%  Controladora control = (Controladora) miSesion.getAttribute("control");
                                    
                                        //Traigo la lista de habitaciones cargadas para mostrarlas en un select
                                        List<Habitacion> listaHabitaciones = control.getHabitaciones();
                                        for (Habitacion hab : listaHabitaciones) {

                                    %>

                                    <% String nombreHab = hab.getNombre();%>
                                    <option value="<%= hab.getId_hab()%>"><%=nombreHab + " " + " | " + "ID: " + hab.getId_hab()%></option>

                                    <% int id_hab = hab.getId_hab();%>
                                    <%  }  %>
                                </select>  

                                <select class="selectbonito" name="selectHuesped">

                                    <%
                                        //Traigo la lista de huespedes cargados para mostrarlos en un select
                                        List<Huesped> listaHuespedes = control.getHuespedes();
                                        for (Huesped hue : listaHuespedes) {

                                    %>

                                    <% String nombreHue = hue.getNombre();%>
                                    <% String apellidoHue = hue.getApellido();%>
                                    <option value="<%= hue.getId()%>"><%=nombreHue + " " + apellidoHue + " " + " | " + "ID: " + hue.getId()%></option>


                                    <%  }  %>
                                </select>  



                                <input type="date" name="check_in" placeholder="Fecha de entrada">
                                <input type="date" name="check_out" placeholder="Fecha de salida">

                                <input type="number" name="cant_per" placeholder="Cantidad de personas a hospedarse">


                                <input type="submit" value="Registrar">
                            </form>

                            <br>

                            <button type="button" onclick="location.href = 'Principal.jsp'" class="btn btn-dark" data-title="Volver" style="display_inline"> Regresar</button>

                        </div>
                    </div>
                    <div class="col-6">
                        <h2 class="text-right"></h2>
                        <img src="imgs/shape.png">
                    </div>
                </div>
            </div>
            <div></div>
        </div>

        <div class="copyright noto-font-family">
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <p>Leandro Nahuel Bartucca - Trabajo practico final integrador, curso Desarrollo web fullstack con Java - 2021. </p>
        </div>

        <%            }
        %>
    </body>
</html>
