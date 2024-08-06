var tareas = [
    { tarea: "Pintar la fachada de la casa" },
    { tarea: "Comprar comida para el perro" },
    { tarea: "Pagar la tarjeta de crédito" }
]

const tablaTareas = document.getElementById("cuerpo-tabla");

for (let i = 0; i < tareas.length; i++) {
  const row = tablaTareas.insertRow();
  const celdaNombre = row.insertCell(0);
  const celdaDescripcion = row.insertCell(1);
  celdaNombre.textContent = tareas[i].tarea;

  const boton = document.createElement('button');
  boton.type = "button";
  boton.className = "btn btn-danger"
  boton.textContent = 'Finalizar';
  boton.addEventListener('click', () => {
    console.log('Botón presionado para la tarea ' + tareas[i].tarea);
    // Aquí puedes agregar el código que deseas ejecutar cuando se presiona el botón
  });

  celdaDescripcion.appendChild(boton);
}


const botonTarea = document.getElementById("agregarTarea");
const botonAgregar = document.getElementById("agregar");
const tareaIngresada = document.getElementById("nuevaTarea")

var contador = 0;
botonTarea.addEventListener('click', (agregarTarea));
botonAgregar.addEventListener('click', (agregar));


function agregarBotonFinalizar(){

}

function agregarTarea() {
    formulario.style.display = 'block';
    if (contador==0){
        formulario.style.display = 'block';
        contador = 1;
    }else{
        formulario.style.display = 'none';
        contador = 0;
    }
}

function agregar() {
    
    const isTareaExistente = tareas.some(tarea => tarea.tarea === tareaIngresada.value);

    if (isTareaExistente || tareaIngresada.value == "") {
      alert("Ingrese una tarea valida o no existente");
    }else {
      console.log("El valor ingresado no está en la lista de tareas.");
      const row = tablaTareas.insertRow();
      const celdaNombre = row.insertCell(0);
      const celdaDescripcion = row.insertCell(1);
      celdaNombre.textContent = tareaIngresada.value;
      const boton = document.createElement('button');
      boton.type = "button";
      boton.className = "btn btn-danger";
      boton.textContent = 'Finalizar';
      celdaDescripcion.appendChild(boton);
      tareas.push({ tarea: tareaIngresada.value });
      tareaIngresada.value = "";
      console.log(tareas);
 



    }
}




