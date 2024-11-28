<%@page import="Modelo.usuario"%>
<%@page import="Modelo.Alojamiento"%>
<%@page import="Modelo.DAOAlojamiento"%>
<%@page import="Modelo.Reserva"%>
<%@page import="Modelo.DAORESERVA"%>
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    // Validación del ID de Alojamiento de la solicitud
    String idAlojamientoStr = request.getParameter("idAlojamiento");
    Alojamiento alojamiento = null;
    
    if (idAlojamientoStr != null) {
        try {
            int idAlojamiento = Integer.parseInt(idAlojamientoStr);
            
            // Obtener los datos del alojamiento
            DAOAlojamiento daoAlojamiento = new DAOAlojamiento();
            alojamiento = daoAlojamiento.obtenerAlojamientoPorId(idAlojamiento);
            
            if (alojamiento == null) {
                out.println("<p>Error: Alojamiento no encontrado.</p>");
                return;
            }
        } catch (NumberFormatException e) {
            out.println("<p>Error: ID de alojamiento no válido.</p>");
            return;
        }
    } else {
        out.println("<p>Error: ID de alojamiento no especificado.</p>");
        return;
    }
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
            <h3 class="subtittle">Reserva tu <%= alojamiento.getNombre()%></h3>
            <p>Prepárate para vivir una experiencia como ninguna otra, en el Glamping Malibú podrás disfrutar de los más bellos paisajes,
                 atardeceres e inolvidables actividades alrededor de la naturaleza.</p>
            <p>Puedes venir sólo, con tus amigos, familiares y mascotas, no te arrepentirás.</p>
            <p>¡Te esperamos!</p>
        </div>
    </section>
    <section class="gallery-section">
        <div id="div_Reserva">
            <div>
                <h1><%= alojamiento.getNombre() %></h1>
                <p><%= alojamiento.getDescripcion() %></p>
                <p>Precio por noche: <%= alojamiento.getPrecio() %></p>
            </div>
            <div>
                <img src="<%= alojamiento.getRutaFoto() %>" alt="<%= alojamiento.getNombre() %>" width="300">
            </div>
        </div>
        <div id="formulario_Reserva">
            <h3>Formulario de Reserva</h3>
            <form action="ReservaServlet?accion=agregar" method="post">
                <input type="text" name="nombreCompleto" id="nombre" value="" placeholder="Nombre completo" required/>
                <input type="number" name="ced" id="ced" min="0" placeholder="Cédula" required/>
                <input type="email" name="email" id="mail" placeholder="Correo" required/>
                <input type="number" name="cantidadHuespedes" min="0" placeholder="Cantidad de huespedes" required>
                <div class="formResInput">
                    <h5>Seleccione medio de pago:</h5>
                    <input type="radio" id="PSE" name="fav_language" value="PSE">
                    <label for="PSE">PSE</label><br>
                    <input type="radio" id="Tarjeta" name="fav_language" value="Tarjeta">
                    <label for="Tarjeta">Tarjeta de Crédito/Débito</label><br>
                    <input type="radio" id="PayPal" name="fav_language" value="PayPal">
                    <label for="PayPal">PayPal</label>
                </div>
                <input type="hidden" name="idAlojamiento" value="<%= alojamiento.getIdAlojamiento() %>">
                <input type="hidden" name="idUsuario" value="<%= ((usuario)session.getAttribute("usuario")).getId_usuario() %>">
                <input type="hidden" name="precioPorNoche" value="<%= alojamiento.getPrecio() %>">
                <div id="Selec_Fechas">
                    <div>
                        <label for="fechaInicio">Fecha de ingreso:</label>
                        <input type="date" name="fechaInicio" required>
                    </div>
                    <div>
                        <label for="fechaFin">Fecha de salida:</label>
                        <input type="date" name="fechaFin" required>
                    </div>
                </div>
                <button type="submit" class="btn">Reservar</button>
            </form>
        </div>
    </section>
</body>
</html>

