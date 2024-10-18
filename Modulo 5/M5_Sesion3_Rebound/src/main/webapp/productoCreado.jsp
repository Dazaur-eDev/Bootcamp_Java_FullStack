<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Producto Creado con Sessions</title>
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
            <a class="navbar-brand" href="#">Modulo 5 - Sesion 3 - Rebound - Producto creado con Sessions</a>
        </div>
    </nav>
</header>

<div class="container-fluid mt-5">
    <div class="row justify-content-center min-vh-100">
        <div class="col-md-6 ">
            <!-- Titulo de la pagina -->
            <h1 class="text-center mb-4">PRODUCTO CREADO</h1>
            <div class="alert alert-success " role="alert">
                <p class="mb-0 text-center">Se ha creado un producto en Servlet mediante Sessions.</p>
            </div>
            <!--Lista de datos ingresados -->
            <fieldset disabled>
                <div class="mb-3 w-min">
                    <label for="id" class="form-label text-left">Código identificador</label>
                    <input type="text" class="form-control bg-dark text-white" id="id" name="id"
                           value="<%= request.getAttribute("id")%>">

                    <label for="concepto" class="form-label text-left">Nombre del Producto</label>
                    <input type="text" class="form-control bg-dark text-white" id="concepto" name="concepto"
                           value="<%= request.getAttribute("concepto")%>">

                    <label for="importe" class="form-label text-left">Precio</label>
                    <input type="text" class="form-control bg-dark text-white" id="importe" name="importe"
                           value="<%= request.getAttribute("importe")%>">
                </div>
            </fieldset>
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
        <p class="small m-1"> 2024 eDev_Daza. Todos los derechos reservados.</p>
    </div>
</footer>

</body>
</html>
