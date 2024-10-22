<%-- 
    Document   : quienes-somos
    Created on : 21 oct 2024, 13:50:22
    Author     : mega_
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quienes Somos</title>
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
            <h3 class="subtittle">Quienes Somos</h3>
            <p>El Glamping Malibú nació en el año 2020, como una alternativa ecológica que busca promover el turismo en el departamento del Quindío. Su fundadora María Quiróz en conjunto con sus familiares, han dado vida a este destino paradisiaco al interior de las montañas y rodeado de unas vistas sin igual.</p>
            <p>El Glamping Malibú ofrece una gran cantidad de actividades físicas entre las que encontramos: senderismo, fotografía, parapente, fogatas bajo las estrellas y aventuras acuáticas.</p>
            <p>A tan solo 15 kms de la capital del departamento puedes encontrar nuestras instalaciones, aquí podrás hospedarte en habitaciones tradicionales hasta domos al aire libre.</p>
            <p>El Glamping es completamente sustentable y no impacta negativamente al medio ambiente, además y como si fuera poco, es pet friendly, así que puedes venir con tu mascota y disfrutar juntos en familia.</p>
            <p>Nuestro mayor compromiso es con la calidad y satisfacción de nuestros visitantes.</p>
        </div>
        <a href="reserva.jsp" class="btn-reserva">¡RESERVA AQUÍ!</a>
    </section>
    <section class="social-section">
        <h2>Síguenos en Redes Sociales</h2>
        <div class="social-links">
            <a href="https://wa.me/573207777663" target="_blank" class="redes"><img src="Images/iconosRedes/whatsapp.png" alt=""></a>
            <a href="https://www.instagram.com/explore/locations/107262155433881/glamping-malibu/" target="_blank" class="redes"><img src="Images/iconosRedes/instagram.png" alt=""></a>
            <a href="https://www.facebook.com/glampingmalibu/" target="_blank" class="redes"><img src="Images/iconosRedes/facebook.png" alt=""></a>
        </div>
    </section>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
    <script src="script.js"></script>
</body>
</html>