// Lista original de tareas ya almacenadas
var tareas = [
  { tarea: "Pintar la fachada de la casa" },
  { tarea: "Comprar comida para el perro" },
  { tarea: "Pagar la tarjeta de crédito" },
];

// Recuperar objetos de html para usar en JS
const tablaTareas = document.getElementById("cuerpo-tabla");
const botonTarea = document.getElementById("agregarTarea");
const botonAgregar = document.getElementById("agregar");
const tareaIngresada = document.getElementById("nuevaTarea");
var contador = 0;


// Cargar los datos de la lista inicial junto con el boton de finalizar y su funcionalidad
for (let i = 0; i < tareas.length; i++) {
  const row = tablaTareas.insertRow();
  const celdaNombre = row.insertCell(0);
  const celdaDescripcion = row.insertCell(1);
  celdaNombre.textContent = tareas[i].tarea;

  const boton = document.createElement("button");
  boton.type = "button";
  boton.className = "btn btn-danger";
  boton.textContent = "Finalizar";
  boton.addEventListener("click", () => {
    tareas.splice(i, 1);
    row.remove();
  });
  celdaDescripcion.appendChild(boton);
}

// Funcionalidades
function desplegarAgregarTarea() {
  formulario.style.display = "block";
  if (contador == 0) {
    formulario.style.display = "block";
    tareaIngresada.value = "";
    contador = 1;
  } else {
    formulario.style.display = "none";
    contador = 0;
  }
}

function agregar() {
  const isTareaExistente = tareas.some((tarea) => tarea.tarea === tareaIngresada.value
  );

  if (isTareaExistente || tareaIngresada.value == "") {
    alert("Ingrese una tarea valida o no existente");
  } else {
    console.log("El valor ingresado no está en la lista de tareas.");
    const row = tablaTareas.insertRow();
    const celdaNombre = row.insertCell(0);
    const celdaDescripcion = row.insertCell(1);
    celdaNombre.textContent = tareaIngresada.value;
    const boton = document.createElement("button");
    boton.type = "button";
    boton.className = "btn btn-danger";
    boton.textContent = "Finalizar";
    celdaDescripcion.appendChild(boton);
    tareas.push({ tarea: tareaIngresada.value });
    tareaIngresada.value = "";
    console.log(tareas);
    boton.addEventListener("click", () => {
      tareas.splice(tareas.length - 1, 1);
      row.remove();
    });
    formulario.style.display = "none";
    contador = 0;
  }
}


// disparadores de eventos
botonTarea.addEventListener("click", desplegarAgregarTarea);
botonAgregar.addEventListener("click", agregar);