<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% 
   response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
   response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
   response.setDateHeader("Expires", 0); // Proxies.
   
   if (session == null || session.getAttribute("usuario") == null) {
      response.sendRedirect(request.getContextPath() + "/login.jsp");
      return;
   }else{
%>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Glamping</title>
    <link rel="icon" href="Images/iconosRedes/camping_holiday_excursion_camp_tent_icon_258744.ico">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/estilos.css">
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
                <a href="${pageContext.request.contextPath}/index.jsp"><h1 class="name-glamping">Glamping</h1></a>
                <a href="${pageContext.request.contextPath}/index.jsp"><h1 class="name-malibu">Malibú</h1></a>
            </div>
            <div class="hero-conexion">
                <div class="container-conexion">
                    <h2 class="conexion">Bienvenido</h2>
                    <h2 class="natural">${usuario.nombreUsuario}</h2>
                </div>
            </div>
            <div class="hero-buttons">
                <button class="abrir-menu" id="abrir"><i class="bi bi-list"></i></button>
                <nav class="nav-buttons" id="nav">
                    <button class="cerrar-menu" id="cerrar"><i class="bi bi-x-circle"></i></button>
                    <ul class="nav-list">
                        <li><a href="srvUsuario?action=cerrar" class="btn">Cerrar Sesión</a></li>
                        <li><a href="quienes-somos.jsp" class="btn">Quiénes Somos</a></li>
                        <li><a href="#galeria" class="btn" id="galeria-btn">Galería</a></li>
                    </ul>
                </nav>
            </div>
        </div>
    </section>
    <section class="description-section">
        <div class="hero-description">
            <h3 class="subtittle">Usted es ${usuario.cargo.nombreCargo}</h3>
            <p>Nombre: ${usuario.nombre}</p>
            <p>Apellido: ${usuario.apellido}</p>
            <p>cedula: ${usuario.cedula}</p>
            <p>email: ${usuario.email}</p>
        </div>
        <div>
            <a href="${pageContext.request.contextPath}/UsuarioServlet?accion=listar" class="btn">Ver Usuarios Registrados</a>
            <a href="${pageContext.request.contextPath}/ReservacionesServlet?accion=listar" class="btn">Ver reservaciones</a>
        </div>
    </section>
    <section class="gallery-section">
        <div>
            <div class="row">
                <div id="contenedor1">
                    <h1>Crear administrador</h1>
                    <form id="form1" action="RegisterServlet?accion=registrarAdmin" method="POST">
                        <input type="text" name="username" id="username" value="" placeholder="Usuario" required/>
                        <hr>
                        <input type="text" name="name" id="name" value="" placeholder="Nombres" required/>
                        <hr>
                        <input type="text" name="lastname" id="lastname" value="" placeholder="Apellidos" required/>
                        <hr>
                        <input type="number" name="cedula" id="cedula" min="0" placeholder="Cédula" required/>
                        <hr>
                        <input type="email" name="email" id="email" placeholder="email" required/>
                        <hr>
                        <input type="password" name="password" id="password" value="" placeholder="Contraseña" required>
                        <hr>
                        <select name="genero" id="genero">
                            <option value="1">Hombre</option>
                            <option value="2">Mujer</option>
                        </select>
                        <hr>
                        <input type="submit" name="registrarse" value="Registrarse" class="btn"/>
                        <p>${msje}</p>
                    </form>
                </div>
            </div>
        </div>
    </section>
    <section class="social-section">
        <div class="pie-de-pagina">
            <p>Diseñado por John Aparicio, Fabio González y Duchley Hoyos.</p>
            <p>Para Servicio Nacional de Aprendizaje SENA</p>
        </div>
    </section>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
    <script src="script.js"></script>
</body>
</html>
<%
    }
%>