$(document).ready( 
    function() {
        var contadorClic = 0
        $("#text1").mouseenter(function(){
            $("#text2").show();
        })
        $("#text1").mouseleave(function(){
            $("#text2").hide();
        })
        $("#caja2").click(function(){
            if(contadorClic ==0){
                $("#img").width("100%");
                contadorClic=1;
            }else if(contadorClic==1){  
                $("#img").width("50%");
                contadorClic=0;
            }
        })
        $("#caja2").mouseleave(function(){
            $("#img").width("50%");
            contadorClic=0;
        })
        $("#caja3").dblclick(function(){
            if(contadorClic ==0){
                $("#caja3").css("font-size","200%");
                contadorClic=1;
            }else if(contadorClic==1){  
                $("#caja3").css("font-size","100%");
                contadorClic=0;
            }
            
        })

    }

)
