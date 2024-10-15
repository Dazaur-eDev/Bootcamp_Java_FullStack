<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Conexión a Base de Datos</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<nav class="navbar navbar-light bg-info">
    <span class="navbar-brand p-3">Java Bootcamp - Modulo 5 - Learning JSP, Servlet, JDBC</span>
    <span class="navbar-brand p-3">Daza  - Octubre 2024</span>
</nav>

<div class="container mt-5">
    <h1 class="text-center mb-4">Sistema de Estudiantes</h1>

    <div class="row justify-content-center mb-4">
        <div class="col-md-6 text-center">
            <a href="./listarAlumnos" class="btn btn-primary">Conectar a la Base de Datos</a>
        </div>
    </div>

    <div id="mensaje" class="mt-4 text-center"></div>
</div>

<!-- Bootstrap JS y Popper.js -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>