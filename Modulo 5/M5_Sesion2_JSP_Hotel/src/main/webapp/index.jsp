<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Hotel JSP</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<nav class="navbar bg-body-tertiary">
    <div class="container-fluid">
        <span class="navbar-brand mb-0 h1">Aplicación de Hotel</span>
    </div>
</nav>
<form action="/formHabServlet" method="post">
    <div class="mb-3">
        <label for="nombre" class="form-label">Nombre</label>
        <input type="text" class="form-control" id="nombre" placeholder="Ingrese su nombre">
    </div>
    <div class="mb-3">
        <label for="email" class="form-label">Email</label>
        <input type="text" class="form-control" id="email" placeholder="123@123.com">
    </div>
    <div class="mb-3">
        <label for="dias" class="form-label">Días</label>
        <input type="text" class="form-control" id="dias" placeholder="Ingrese cantidad de días">
    </div>
</form>
<div class="container-fluid">
    <a href="/formHabServlet" class="btn btn-primary btn-lg">Reserva aquí</a>
</div>

<%--<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>--%>
</body>
</html>
