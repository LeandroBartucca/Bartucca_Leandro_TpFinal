<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Cargar Habitacion</title>
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
                <h2 id="contact">Cargar Habitacion</h2>
                <div class="row">
                    <div class="col-6">
                        <div class="contact-form">
                            <form action="SvCargarHabitacion" method="POST">
                                <input type="text" name="num_hab" placeholder="Numero de habitacion">
                                <input type="text" name="piso" placeholder="Piso">
                                <input type="text" name="nombre" placeholder="Nombre">

                                <select class="selectbonito" name="tipo">
                                    <option>Single</option>
                                    <option>Doble</option>
                                    <option>Triple</option>
                                    <option>Multiple</option>
                                </select>
                                <input type="number" name="precio_noche" placeholder="Precio por noche">


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
