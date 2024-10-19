<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inicio de Sesion</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="assets/styles/styles.css">
</head>

<body>

<header>
    <!-- Navbar -->
    <nav class="navbar navbar-dark bg-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">Modulo 5 - Sesion 3 - Evaluation - Inicio</a>
        </div>
    </nav>
</header>

<div class="container">

    <div class="row justify-content-center align-items-center min-vh-100">
        <!-- Primera card para inicio con Request-->
        <div class="col-md-4 col-lg-4">
            <div class="card shadow">
                <div class="card-body">
                    <%
                        String mensaje = request.getParameter("mensaje");
                        if (mensaje != null) {
                    %>
                    <div class="alert alert-success text-center" role="alert">
                        <%= mensaje %>
                    </div>
                    <%
                        }
                    %>
                    <h2 class="card-title text-center mb-4">Iniciar Sesión</h2>
                    <form action="./loginServletConRequest" method="post">
                        <div class="mb-3">
                            <label for="nombre" class="form-label">Nombre</label>
                            <input type="text" class="form-control" id="nombre" name="nombre" required>
                        </div>
                        <div class="mb-3">
                            <label for="contrasena" class="form-label">Contraseña</label>
                            <input type="password" class="form-control" id="contrasena" name="contrasena" required>
                        </div>
                        <div class="d-grid">
                            <button type="submit" class="btn btn-dark">Ingresar con Request</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>

        <!-- Segunda card para inicio con Sessions-->
        <div class="col-md-4 col-lg-4">
            <div class="card shadow">
                <div class="card-body">
                    <%
                        mensaje = request.getParameter("mensaje2");
                        if (mensaje != null) {
                    %>
                    <div class="alert alert-success text-center" role="alert">
                        <%= mensaje %>
                    </div>
                    <%
                        }
                    %>
                    <h2 class="card-title text-center mb-4">Iniciar Sesión</h2>
                    <form action="./loginServletConSessions" method="post">
                        <div class="mb-3">
                            <label for="nombre2" class="form-label">Nombre</label>
                            <input type="text" class="form-control" id="nombre2" name="nombre2" required>
                        </div>
                        <div class="mb-3">
                            <label for="contrasena2" class="form-label">Contraseña</label>
                            <input type="password" class="form-control" id="contrasena2" name="contrasena2" required>
                        </div>
                        <div class="d-grid">
                            <button type="submit" class="btn btn-dark">Ingresar con Sessions</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>

        <!-- Tercera card para inicio con Cookies-->
        <div class="col-md-4 col-lg-4">
            <div class="card shadow">
                <div class="card-body">
                    <%
                        mensaje = request.getParameter("mensaje3");
                        if (mensaje != null) {
                    %>
                    <div class="alert alert-success text-center" role="alert">
                        <%= mensaje %>
                    </div>
                    <%
                        }
                    %>
                    <h2 class="card-title text-center mb-4">Iniciar Sesión</h2>
                    <form action="./loginServletConCookies" method="post">
                        <div class="mb-3">
                            <label for="nombre3" class="form-label">Nombre</label>
                            <input type="text" class="form-control" id="nombre3" name="nombre3" required>
                        </div>
                        <div class="mb-3">
                            <label for="contrasena3" class="form-label">Contraseña</label>
                            <input type="password" class="form-control" id="contrasena3" name="contrasena3" required>
                        </div>
                        <div class="d-grid">
                            <button type="submit" class="btn btn-dark">Ingresar con Cookies</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>

    </div>
</div>


<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>

<!-- Footer -->
<footer class="bg-dark text-white text-center">
    <div class="container-fluid">
        <p class="small m-1"> © 2024 eDev_Daza. Todos los derechos reservados.</p>
    </div>
</footer>

</body>
</html>