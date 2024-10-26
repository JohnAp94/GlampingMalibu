<%-- 
    Document   : index
    Created on : 21 oct 2024, 12:54:06
    Author     : John
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Glamping Malibú</title>
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
            <h3 class="subtittle">¡Una experiencia que transformará tu vida!</h3>
            <p>Prepárate para vivir una experiencia como ninguna otra, en el Glamping Malibú podrás disfrutar de los más bellos paisajes,
                 atardeceres e inolvidables actividades alrededor de la naturaleza.</p>
            <p>Puedes venir sólo, con tus amigos, familiares y mascotas, no te arrepentirás.</p>
            <p>¡Te esperamos!</p>
        </div>
        <a href="Cliente/cliente.jsp" class="btn-reserva">¡RESERVA AQUÍ!</a>
    </section>
    <section class="gallery-section">
        <div>
            <div class="row">
                <div class="">
                    <h2 class="gallery-tittle" id="galeria">¡Vive tu mejor experiencia!</h2>
                    <div class="carousel">
                        <div class="carousel-item"><img src="Images/image01.jpg" alt="Imagen 1"></div>
                        <div class="carousel-item"><img src="Images/image02.jpg" alt="Imagen 2"></div>
                        <div class="carousel-item"><img src="Images/image03.jpg" alt="Imagen 3"></div>
                        <div class="carousel-item"><img src="Images/image04.jpg" alt="Imagen 4"></div>
                        <div class="carousel-item"><img src="Images/image05.jpg" alt="Imagen 5"></div>
                        <div class="carousel-item"><img src="Images/image06.jpg" alt="Imagen 6"></div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <section id="opiniones" class="reviews-section">
        <div class="linea-division container"></div>
        <div class="container-reviews">
            <h2 class="titulo-valoracion">Valoraciones de usuarios</h2>
            <div class="container-valoraciones">
                <div class="review">
                    <div class="image-container"><img src="Images/Mujer.png" alt="img mujer"></div>
                    <div class="review-content">
                        <h3>Isabella Carrillo</h3>
                        <img src="Images/5stars.png" alt="5 estrellas">
                        <p>"Sencillamente inolvidable, sin duda alguna volveré en mis próximas vacaciones."</p>
                    </div>
                </div>
                <div class="review">
                    <div class="image-container"><img src="Images/Hombre.png" alt="img hombre"></div>
                    <div class="review-content">
                        <h3>Alex Freeman</h3>
                        <img src="Images/5stars.png" alt="5 estrellas">
                        <p>"This place is gorgeous, the landscapes are perfect, this is my new favorite place to visit when I come to Colombia."</p>
                    </div>
                </div>
                <div class="review">
                    <div class="image-container"><img src="Images/Hombre.png" alt="img hombre"></div>
                    <div class="review-content">
                        <h3>Marco A. Solis</h3>
                        <img src="Images/5stars.png" alt="5 estrellas">
                        <p>"Tenía buenas expectativas, sin embargo esta experiencia las superó con creces, ya estamos planeando el próximo paseo
                             familiar y creo que solo debemos fijar la fecha, pues el lugar está!"</p>
                    </div.review-content
                   >
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
