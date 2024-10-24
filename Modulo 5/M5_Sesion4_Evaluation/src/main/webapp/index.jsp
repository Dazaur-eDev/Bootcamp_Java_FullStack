<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inicio de Sesión</title>
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
            <a class="navbar-brand" href="#">Modulo 5 - Sesión 4 - Rebound - Evaluation - Inicio</a>
        </div>
    </nav>
</header>

<div class="container-fluid flex-grow-1 d-flex justify-content-center align-items-center">
    <!-- Card para iniciar Sesión-->
    <div class="col-12 col-sm-8 col-md-6 col-lg-4">
        <div class="card shadow rounded-4">
            <div class="card-body card-glow rounded-4">
                <h2 class="card-title text-center mb-4">Iniciar Sesión</h2>
                <form action="./listarAlumnos" method="get">
                    <div class="mb-3">
                        <label for="nombre" class="form-label">Nombre</label>
                        <input type="text" class="form-control" id="nombre" name="nombre">
                    </div>
                    <div class="mb-3">
                        <label for="contrasena" class="form-label">Contraseña</label>
                        <input type="password" class="form-control" id="contrasena" name="contrasena">
                    </div>
                    <div class="d-grid">
                        <button type="submit" class="btn btn-darkLog">Ingresar</button>
                    </div>
                </form>
            </div>
        </div>
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
