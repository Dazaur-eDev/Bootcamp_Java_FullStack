<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Datos de Reserva</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<nav class="navbar bg-body-tertiary">
    <div class="container-fluid">
        <span class="navbar-brand mb-0 h1">Datos de Reserva</span>
    </div>
</nav>

<body>
<table class="table" class="ms-3">
    <thead>
    <tr>
        <th scope="col">Nombre</th>
        <th scope="col">Email</th>
        <th scope="col">Dias</th>
        <th scope="col">Habitacion</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td><%= request.getAttribute("nombre") %></td>
        <td><%= request.getAttribute("email") %></td>
        <td><%= request.getAttribute("dias") %></td>
        <td><%= request.getAttribute("idHb") %></td>
    </tr>
    </tbody>
</table>
</body>
</html>
