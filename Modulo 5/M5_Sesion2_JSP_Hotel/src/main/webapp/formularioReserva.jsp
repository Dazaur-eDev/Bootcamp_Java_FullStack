<%@ page import="java.util.List" %>
<%@ page import="com.daza.m5_sesion2_jsp_hotel.modelo.Habitacion" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Reserva habitación</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="assets/estilos/estilos.css">
</head>
<body>

<nav class="navbar bg-body-tertiary">
    <div class="container-fluid">
        <span class="navbar-brand mb-0 h1">Formulario de Reserva</span>
    </div>
</nav>

<div class="row row-cols-1 row-cols-md-2 row-cols-lg-4 g-1">
    <% List<Habitacion> lhb = (List<Habitacion>) request.getAttribute("listaDeHabitaciones");
        for (Habitacion habitacion : lhb) {
    %>
    <div class="col mb-2 p-4">
        <img src="<%=habitacion.getImagen()%>" class="card-img-top" alt="Descripcion Imagen" height="">
        <div class="card-body">
            <h5 class="card-title"><%=habitacion.getNombre()%></h5>
            <p class="card-text"><%=habitacion.getDescripcion()%></p>
            <p class="card-text">Precio: $ <%=habitacion.getPrecio()%></p>
            <p class="card-text">Piezas: $ <%=habitacion.getPiezas()%></p>
            <p class="card-text">Metraje: $ <%=habitacion.getMetraje()%></p>
            <a href="/formHabServlet" class="btn btn-primary">Reserva YA!</a>
        </div>
    </div>
    <% } %>
</div>

</body>
</html>
