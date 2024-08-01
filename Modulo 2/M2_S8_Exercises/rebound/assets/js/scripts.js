
var selection = parseInt(prompt("Selecciona el número de la opción que requieres: \n 1. Ver camara en modo normal \n 2. Ver camara en modo termico  \n 3. Verificar la calidad e intensidad de la señal \n 4. Revisar la base de datos de imágenes \n 5. Salir"));

while(selection!=5){
 
    if(selection<1 || selection>5){
        alert("La opción elegida no existe, por favor vuelva a intentar")
    } else if (selection==1){
        alert("Cambio a modo normal");
    } else if (selection==2){
        alert("Cambio a modo termal");
    } else if (selection==3){
        alert("Calidad e intensidad son óptimas");
    } else if (selection==4){
        alert("Sera transferido a la biblioteca de imágenes ");
    } else if (selection==5){
        alert("Muchas Gracias, vuelva pronto");        
    } else{
        alert("La opción en blanco o texto no es posible, debe seleccionar la opcion entre 1 a 5, por favor vuelva a intentar")
    }
    selection = parseInt(prompt("Selecciona el número de la opción que requieres: \n 1. Ver camara en modo normal \n 2. Ver camara en modo termico  \n 3. Verificar la calidad e intensidad de la señal \n 4. Revisar la base de datos de imágenes \n 5. Salir"));
}



        


