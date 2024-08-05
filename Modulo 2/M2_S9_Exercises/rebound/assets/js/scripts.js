// Obtener los elementos del html 
    const text1 = document.getElementById("text1");
    const text2 = document.getElementById("text2");
    const caja1 = document.getElementById("caja1");
    const caja2 = document.getElementById("caja2");
    const img = document.getElementById("img");
    const caja3 = document.getElementById("caja3");

// Funciones
function mostrarTexto2(){
    text2.style.display = "block";
}
function ocultarTexto2(){
    text2.style.display = "none";
}
function agrandarImagen(){
    img.style.width = "50%";
}
function achicarImagen(){
    img.style.width = "20%";
}
function agrandarTexto3(){
    caja3.style.fontSize = "200%";
}

// Disparadores
text1.addEventListener("mouseover", mostrarTexto2);
text1.addEventListener("mouseout", ocultarTexto2);
caja2.addEventListener("click", agrandarImagen);
caja2.addEventListener("mouseover", achicarImagen);
caja3.addEventListener("dblclick", agrandarTexto3);

