// Obtener los elementos del html 
    const text1 = document.getElementById("text1");
    const text2 = document.getElementById("text2");
    const caja1 = document.getElementById("caja1");
    const caja2 = document.getElementById("caja2");
    const img = document.getElementById("img");
    const caja3 = document.getElementById("caja3")
    var count = 0;
// Iniciar texto2 oculto
    text2.style.display = "none";

// Funciones
function mostrarTexto2(){
    text2.style.display = "block";
}
function ocultarTexto2(){
    text2.style.display = "none";
}
function agrandarImagen(){
    img.style.width = "60%";
}
function achicarImagen(){
    img.style.width = "20%";
}
function modificarTexto3(){
    if (count==0){
        caja3.style.fontSize = "200%";
        count = 1;      
    }else{
        caja3.style.fontSize = "100%";
        count=0
    }
}

// Disparadores
text1.addEventListener("mouseover", mostrarTexto2);
text1.addEventListener("mouseout", ocultarTexto2);
caja2.addEventListener("click", agrandarImagen);
caja2.addEventListener("mouseover", achicarImagen);
caja3.addEventListener("dblclick", modificarTexto3);
