<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<% 
   response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
   response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
   response.setDateHeader("Expires", 0); // Proxies.

   if (session == null || session.getAttribute("usuario") == null) {
      response.sendRedirect(request.getContextPath() + "/login.jsp");
      return;
   } else {
%>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lista de Reservaciones</title>
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
            <h3 class="subtittle">Reservaciones</h3>
            <p>Nombre: ${usuario.nombre}</p>
            <p>Apellido: ${usuario.apellido}</p>
            <p>Cédula: ${usuario.cedula}</p>
            <p>Email: ${usuario.email}</p>
        </div>
        <div>
            <a href="registerAdmin.jsp" class="btn">Registrar nuevo administrador</a>
            <a href="${pageContext.request.contextPath}/UsuarioServlet?accion=listar" class="btn">Ver Usuarios Registrados</a>
        </div>
    </section>
    <section class="gallery-section">
        <div class="containerListaUsuarios">
            <h1 id="tituloListaUsuarios">Lista de Reservaciones</h1>
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>ID Reservación</th>
                        <th>Alojamiento</th>
                        <th>Usuario</th>
                        <th>Fecha Ingreso</th>
                        <th>Fecha Salida</th>
                        <th>Valor Total</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="reserva" items="${listaReservas}">
                        <tr>
                            <td>${reserva.idReserva}</td>
                            <td>${reserva.nombreAlojamiento}</td>
                            <td>${reserva.nombreUsuario}</td>
                            <td>${reserva.fechaInicio}</td>
                            <td>${reserva.fechaFin}</td>
                            <td>$<fmt:formatNumber value="${reserva.total}" type="number" maxFractionDigits="0"/></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
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
