<%@page import="Logica.Huesped"%>
<%@page import="Logica.Habitacion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Modificar Huesped</title>
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
                <h2 id="contact">Modificar Huesped</h2>
                <div class="row">
                    <div class="col-6">
                        <div class="contact-form">

                            <%  HttpSession miSesionMHue = request.getSession();
                                //Traigo el huesped en concreto segun la busqueda
                                Huesped hue = (Huesped) miSesionMHue.getAttribute("huesped");

                            %>

                            <form action="SvModificarHue" method="get">
                                <input type="text" name="dni" placeholder="Dni (sin puntos)" value="<%= hue.getDni()%>">
                                <input type="text" name="nombre" placeholder="Nombre" value="<%= hue.getNombre()%>">
                                <input type="text" name="apellido" placeholder="Apellido" value="<%= hue.getApellido()%>">
                                <input type="date" name="fechanac">
                                <input type="text" name="direccion" placeholder="Direccion" value="<%= hue.getDireccion()%>">
                                <input type="text" name="profesion" placeholder="Profesion" value="<%= hue.getProfesion()%>">

                                <input type="hidden" name="id_hue" value="<%= hue.getId()%>">

                                <input type="submit" value="Registrar">
                            </form>

                            <br>

                            <button type="button" onclick="location.href = 'VerHuespedes.jsp'" class="btn btn-dark" data-title="Volver" style="display_inline"> Regresar</button>
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
