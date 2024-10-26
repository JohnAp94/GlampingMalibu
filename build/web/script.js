document.addEventListener('DOMContentLoaded', () => {
    const elementosCarousel = document.querySelectorAll('.carousel');
    M.Carousel.init(elementosCarousel, {
        duration: 150,
        dist: -150,
        shift: 5,
        padding: 0,
        numVisible: 5,
        indicators: true,
        noWrap: false
    });
});

const nav = document.querySelector("#nav");
const abrir = document.querySelector("#abrir");
const cerrar = document.querySelector("#cerrar");
const galeria = document.querySelector("#galeria-btn");

abrir.addEventListener("click", () => {
    nav.classList.add("visible");
});

cerrar.addEventListener("click", () => {
    nav.classList.remove("visible");
});

galeria.addEventListener("click", () => {
    nav.classList.remove("visible");
});