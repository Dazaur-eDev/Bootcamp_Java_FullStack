<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Insertar Alumno</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="assets/styles/styles.css">
</head>

<body class="d-flex flex-column min-vh-100">

<header>
    <!-- Navbar -->
    <nav class="navbar navbar-dark bg-dark card-glow">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">Modulo 5 - Sesión 4 - Rebound - Evaluation - Insertar dato en base de
                datos</a>
        </div>
    </nav>
</header>
<div class="container-fluid flex-grow-1 d-flex justify-content-start align-items-start">
    <div class="ms-5">
        <h2 class="mb-4 mt-5">INSERTAR NUEVO ALUMNO</h2>
        <p>Ingrese la información requerida para agregar el nuevo alumno a la base de datos</p>
        <form action="./insertarAlumno" method="post">
            <div class="mb-3 col-md-6">
                <label for="nombre" class="form-label">Nombre</label>
                <input type="text" class="form-control bg-dark text-white" id="nombre" name="nombre"
                       placeholder="Indique nombre" required>
            </div>
            <div class="mb-3 col-md-6">
                <label for="apellido" class="form-label">Apellido</label>
                <input type="text" class="form-control bg-dark text-white" id="apellido" name="apellido"
                       placeholder="Indique apellido" required>
            </div>
            <div class="mb-3 col-md-6">
                <label for="edad" class="form-label">Edad</label>
                <input type="number" class="form-control bg-dark text-white" id="edad" name="edad"
                       placeholder="Indique edad" required>
            </div>
            <button type="submit" class="btn btn-dark mt-2">Guardar</button>
        </form>
    </div>
</div>


<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>

<!-- Footer -->
<footer class="bg-dark text-white text-center card-glow mt-auto">
    <div class="container-fluid">
        <p class="small m-1"> © 2024 eDev_Daza. Todos los derechos reservados.</p>
    </div>
</footer>

</body>
</html>