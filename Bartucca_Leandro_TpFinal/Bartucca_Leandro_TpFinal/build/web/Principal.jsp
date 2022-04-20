<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Hotel California</title>
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

        <nav class="navbar navbar-expand-lg navbar-light bg-light text-capitalize main-font-family">
            <div class="container">
                <a class="navbar-brand" href="Principal.jsp"><i class="fas fa-hotel"></i></a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#show-menu" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse" id="show-menu">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item active">
                            <a class="nav-link" href="Principal.jsp"> Home <span class="sr-only">(current)</span></a>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Habitaciones
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="CargarHabitacion.jsp">Cargar Habitacion</a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="VerHabitaciones.jsp">Ver habitaciones</a>
                            </div>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Huespedes
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="CargarHuesped.jsp">Cargar Huesped</a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="VerHuespedes.jsp">Ver huespedes</a>
                            </div>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Empleados
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="CargarEmpleado.jsp">Cargar Empleado</a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="VerEmpleados.jsp">Ver empleados</a>
                            </div>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Reservas
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="VerReservas.jsp">Ver reservas</a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="Ganancias.jsp">Ganancias</a>
                            </div>
                        </li>



                        <li class="nav-item book d-flex align-items-center">
                            <a class="nav-link" href="CargarReserva.jsp">Cargar Reserva</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

        <header id="home">
            <div class="small-container">
                <div class="row">
                    <div class="col-lg-4 col-12 lobster-font-family d-flex align-items-center">


                    </div>
                </div>

                <div class="h-slider roboto-font-family welcome d-flex align-items-center justify-content-center">
                    <h1 class="text-capitalize">Bienvenido<br><span>Hotel California</span></h1>
                    <div id="headerslider" class="carousel slide" data-ride="carousel">
                        <div class="carousel-inner">
                            <div class="carousel-item carousel-three active"></div>
                            <div class="carousel-item carousel-two"></div>
                            <div class="carousel-item carousel-one"></div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="st-rec"></div>
            <div class="rd-rec"></div>
        </header>


        <div class="copyright noto-font-family">
            <p>2021. Leandro Nahuel Bartucca - Trabajo practico final integrador, curso Desarrollo web fullstack con Java</p>
        </div>


        <script src="js/jquery-3.3.1.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script>
            $(function () {

                'use strict';

                var winH = $(window).height();

                $('header').height(winH);

                $('.navbar ul.navbar-nav li a').on('click', function (e) {

                    var getAttr = $(this).attr('href');


                    $('html').animate({scrollTop: $(getAttr).offset().top}, 1000);
                });
            });
        </script>

        <%           }
        %>
    </body>
</html>
