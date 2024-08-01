var numero1, numero2, resultado;
numero1 = prompt("Ingresa el primer numero a");
numero2 = prompt("Ingresa el segundo numero a");
numero1=parseInt(numero1)
numero2=parseInt(numero2)

var message = document.getElementById("message");
message.textContent = "Aprendiendo a insertar texto desde Js a html mediante Id";



if (numero1 > numero2){
    resultado = alert("El numero "+numero1+" es mayor que "+numero2+".");
} else if (numero1 < numero2){
    resultado = alert("El numero "+numero2+" es mayor que "+numero1+".");
} else {
    resultado = alert("Los numeros son iguales.");  
}

