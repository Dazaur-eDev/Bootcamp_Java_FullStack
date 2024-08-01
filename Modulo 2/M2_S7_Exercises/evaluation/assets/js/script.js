var opcion = prompt(
  "¡Hola! Soy Eva, tu asistente virtual del Servicio al Cliente de Mentel. Estoy aquí para ayudarte en lo que necesites.\nEscribe el número de la opción que buscas: \n1.- Boletas y Pagos \n2.- Señal y llamadas \n3.- Oferta comercial  \n4.- Otras consultas"
);

function boletas_y_pagos() {
  var boletas = prompt(
    "Seleccione una opción: \n1.- Ver Boleta \n2.- Pagar cuenta"
  );
  if (boletas == 1) {
    alert("Haga clic aquí para descargar su boleta");
  } else if (boletas == 2) {
    alert("Usted esta siendo transferido. Espere por favor...");
  } else {
    alert("La opción ingresada no es válida. Gracias por preferir nuestros servicios");
  }
}
function senal_y_llamadas() {
  var senal = prompt(
    "Seleccione una opción: \n1.- Problemas con la señal \n2.- Problemas con las llamadas"
  );
  if (senal == 1) {
    solicitud = prompt("A continuación escriba su solicitud");
  } else if (senal == 2) {
    solicitud = prompt("A continuación escriba su solicitud");
  } else {
    alert("La opción ingresada no es válida. Gracias por preferir nuestros servicios");
  }
  alert("Estimado usuario, su solicitud: " +solicitud + " ha sido ingresada con éxito. Pronto será contactado por uno de nuestros ejecutivos");
}
function oferta_comercial() {
  var promo = prompt(
    "¡Mentel tiene una oferta comercial acorde a tus necesidades! \n Para conocer más información y ser asesorado personalmente por un ejecutivo escribe 'SI' y un ejecutivo te llamará. De lo contrario ingrese 'NO'"
  );
  if (promo == "Si" || promo == "si" || promo == "SI" || promo == "sI") {
    alert("Un ejecutivo contactará con usted");
  }  else if (promo == "No" || promo == "no" || promo == "NO" || promo == "nO") {
    alert("Gracias por preferir nuestros servicios");
  } else {
    alert("La opción ingresada no es válida. Gracias por preferir nuestros servicios");
  }
}
function otras_consultas() {
  var consulta = prompt("A continuación escriba su consulta");
  alert(
    "Estimado usuario, su consulta: " +consulta + " ha sido ingresada con éxito. Pronto será contactado por uno de nuestros ejecutivos");
}

if (opcion == 1) {
  boletas_y_pagos();
} else if (opcion == 2) {
  senal_y_llamadas();
} else if (opcion == 3) {
  oferta_comercial();
} else if (opcion == 4) {
    otras_consultas()
} else {
  alert(
    "La opción ingresada no es válida. Gracias por preferir nuestros servicios"
  );
}
message.textContent = "Opcion seleccionada "+opcion+" durante el formulario";

