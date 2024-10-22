<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% 
   response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
   response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
   response.setDateHeader("Expires", 0); // Proxies.
%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Malibú</title>
    <link rel="icon" href="Images/iconosRedes/camping_holiday_excursion_camp_tent_icon_258744.ico">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
    <link rel="stylesheet" href="estilos.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Nunito+Sans:ital,opsz,wght@0,6..12,200..1000;1,6..12,200..1000&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Inspiration&family=Nunito+Sans:ital,opsz,wght@0,6..12,200..1000;1,6..12,200..1000&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Mogra&display=swap" rel="stylesheet">
</head>
<body>
    <section class="hero-section">
        <div class="hero-tittle">
            <div class="tittle">
                <a href="index.jsp"><h1 class="name-glamping">Glamping</h1></a>
                <a href="index.jsp"><h1 class="name-malibu">Malibú</h1></a>
            </div>
            <div class="hero-conexion">
                <div class="container-conexion">
                    <h2 class="conexion">CONEXIÓN</h2>
                    <h2 class="natural">NATURAL</h2>
                </div>
            </div>
            <div class="hero-buttons">
                <button class="abrir-menu" id="abrir"><i class="bi bi-list"></i></button>
                <nav class="nav-buttons" id="nav">
                    <button class="cerrar-menu" id="cerrar"><i class="bi bi-x-circle"></i></button>
                    <ul class="nav-list">
                        <li><a href="login.jsp" class="btn">Iniciar Sesión</a></li>
                        <li><a href="quienes-somos.jsp" class="btn">Quiénes Somos</a></li>
                        <li><a href="#galeria" class="btn" id="galeria-btn">Galería</a></li>
                    </ul>
                </nav>
            </div>
        </div>
    </section>
    <section class="description-section">
        <div class="hero-description">
            <h3 class="subtittle">¡Bienvenidos!</h3>
        </div>
    </section>
    <section class="gallery-section">
        <div>
            <div class="row">
                <div id="contenedor1">
                    <h1>Iniciar Sesión</h1>
                    <form id="form1" action="srvUsuario?accion=verificar" method="POST">
                        <input type="text" name="txtUsu" id="txtUsu" value="" placeholder="Usuario"/>
                        <hr>
                        <input type="password" name="txtPass" id="txtPass" value="" placeholder="Contraseña">
                        <hr>
                        <input type="submit" name="verificar" value="Ingresar" class="btn"/>
                        <p>${msje}</p>
                    </form>
                </div>
                <div id="contenedor2">
                    <div id="referencias">
                        <p>¿No tienes cuenta?</p>
                    </div>
                    <form id="form2">
                        <a href="register.jsp" class="btn"/>Registrarse</a>
                    </form>
                </div>
            </div>
        </div>
    </section>
    <section class="social-section">
        <h2>Síguenos en Redes Sociales</h2>
        <div class="social-links">
            <a href="https://wa.me/573207777663" target="_blank" class="redes"><img src="Images/iconosRedes/whatsapp.png" alt=""></a>
            <a href="https://www.instagram.com/explore/locations/107262155433881/glamping-malibu/" target="_blank" class="redes"><img src="Images/iconosRedes/instagram.png" alt=""></a>
            <a href="https://www.facebook.com/glampingmalibu/" target="_blank" class="redes"><img src="Images/iconosRedes/facebook.png" alt=""></a>
        </div>
        <div class="pie-de-pagina">
            <p>Diseñado por John Aparicio, Fabio González y Duchley Hoyos.</p>
            <p>Para Servicio Nacional de Aprendizaje SENA</p>
        </div>
    </section>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
    <script src="script.js"></script>
</body>
</html>
