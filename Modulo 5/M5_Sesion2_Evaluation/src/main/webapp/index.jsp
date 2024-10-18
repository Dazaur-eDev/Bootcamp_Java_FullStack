<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.daza.m5_sesion2_evaluation.dto.ProductoResponseDTO" %>
<%@ page import="com.daza.m5_sesion2_evaluation.model.Producto" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ingreso a compra de Productos</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="assets/styles/styles.css">
</head>


<header>
    <!-- Navbar -->
    <nav class="navbar navbar-dark bg-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">Modulo 5 - Sesion 2 - Evaluation - Inicio</a>
        </div>
    </nav>
</header>

<body>

<div class="container mt-5">
    <!-- Titulo de la pagina -->
    <h1 class="text-center">Bienvenido a tu Distribuidora de <br> repuestos informáticos</h1>

    <!-- Sección de acceso a la lista de productos-->
    <div class="row justify-content-center mt-5">
        <div class="col-md-6">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title text-center mb-4">INGRESE SUS DATOS</h5>
                    <form action="./listarProductos" method="post">
                        <div class="mb-3">
                            <label for="nombre" class="form-label">Nombre</label>
                            <input type="text" class="form-control bg-dark text-white" id="nombre" name="nombre"
                                   placeholder="Ingrese su nombre" required>
                        </div>
                        <div class="mb-3">
                            <label for="direccion" class="form-label">Direccion</label>
                            <input type="text" class="form-control bg-dark text-white" id="direccion" name="direccion"
                                   placeholder="Ingrese su direccion" required>
                        </div>
                        <div class="d-grid">
                            <button type="submit" class="btn btn-dark">Ingresar</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Footer -->
<footer class="bg-dark text-white text-center">
    <div class="container">
        <p class="small m-1">&copy; 2024 eDev_Daza. Todos los derechos reservados.</p>
    </div>
</footer>
<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</body>
</html>