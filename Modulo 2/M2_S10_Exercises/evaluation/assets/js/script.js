$(document).ready(function() {
  //_____________________________________________________________________
  //1era Solucion para el popup de destnos.
  //Solución repetitiva utilizando el ID del boton sin embargo si se 
  //agregan más destinos se requiere actualizar el código
  //____________________________________________________________________
  //   $("#Baires").click(function() {
  //     var idBoton = $("#Baires").attr("id");
  //     $("#detalles" + idBoton).toggle();
  //   });
  //   $("#MachuPicchu").click(function() {
  //     var idBoton = $("#MachuPicchu").attr("id");
  //     $("#detalles" + idBoton).toggle();
  //   });
  //   $("#Rio").click(function() {
  //     var idBoton = $("#Rio").attr("id");
  //     $("#detalles" + idBoton).toggle();
  //   });
  //   $(".btn-close").click(function() {
  //     $(".detalles").hide();
  //   });
  // });
  //_____________________________________________________________________

  //2da Solución más escalable y dinámica para el popup de destinos, debiendo indicarse 
  //en cada clase .text-body-secondary el ID del destino.
  //_____________________________________________________________________
    var arregloDestinos=[];
    var contadorClick=0
    $('.text-body-secondary').each(function() {
      var idDestinos = $(this).attr('id');
      if (idDestinos != null){
        arregloDestinos.push(idDestinos);
      }
    });
    $.each(arregloDestinos, function(index,value) {
        $("#"+value).click(function() {
          if(contadorClick==0){
            $("#detalles"+value).toggle();
            contadorClick=1;
          }else{
            contadorClick=0;
            $(".detalles").hide();
          }
        });
    });

    $(".btn-close").click(function() {
        $(".detalles").hide();
    });
  });