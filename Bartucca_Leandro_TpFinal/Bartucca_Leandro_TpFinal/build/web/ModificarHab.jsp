<%@page import="Logica.Habitacion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Modificar Habitacion</title>
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
                <h2 id="contact">Modificar Habitacion</h2>
                <div class="row">
                    <div class="col-6">
                        <div class="contact-form">

                            <%  HttpSession miSesionMHab = request.getSession();
                                //Traigo la habitacion en concreto segun la busqueda
                                Habitacion hab = (Habitacion) miSesionMHab.getAttribute("habitacion");

                            %>

                            <form action="SvModificarHab" method="get">
                                <input type="text" name="num_hab" placeholder="Numero de habitacion" value="<%= hab.getNum_hab()%>">
                                <input type="text" name="piso" placeholder="Piso" value="<%= hab.getPiso()%>">
                                <input type="text" name="nombre" placeholder="Nombre" value="<%= hab.getNombre()%>">

                                <select class="selectbonito" name="tipo">
                                    <option>Single</option>
                                    <option>Doble</option>
                                    <option>Triple</option>
                                    <option>Multiple</option>
                                </select>

                                <input type="text" name="precio_noche" placeholder="Precio por noche" value="<%=hab.getPrecio_noche()%>">

                                <input type="hidden" name="id_hab" value="<%= hab.getId_hab()%>">

                                <input type="submit" value="Registrar">
                            </form>

                            <br>

                            <button type="button" onclick="location.href = 'VerHabitaciones.jsp'" class="btn btn-dark" data-title="Volver" style="display_inline"> Regresar</button>
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

        <%            }
        %>
    </body>
</html>
