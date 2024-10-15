<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Iniciar Sesión</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body class="bg-light">
<div class="container">
    <div class="row justify-content-center align-items-center min-vh-100">
        <%
            int contadorMinusculas = (int) request.getAttribute("contadorMinisculas");
            int contadorMayusculas = (int) request.getAttribute("contadorMayusculas");
            int contadorNumeros = (int) request.getAttribute("contadorNumeros");
            int deltaMayusculas = 0;
            int deltaMinusculas = 0;
            int deltaNumeros = 0;
            boolean tokenPass = (boolean) request.getAttribute("tokenPass");

            if (contadorMayusculas < 4) {
                deltaMayusculas = (4 - contadorMayusculas);
            }
            if (contadorMinusculas < 3) {
                deltaMinusculas = (3 - contadorMinusculas);
            }
            if (contadorNumeros < 3) {
                deltaNumeros = (3 - contadorNumeros);
            }

            if (!tokenPass) {
        %>
        <div class="col-md-6 text-center">
            <h1 class="display-4 mb-4">¡Acceso Denegado!</h1>
            <div class="alert alert-warning" role="alert">
                <p class="mb-0">Tu contraseña es muy débil.</p>
            </div>
            <p class="lead mb-4">La contraseña debe tener al menos 4 mayúsculas, 3 minúsculas y 3 números.<br>
                Te faltan
                <%= deltaMayusculas %> mayúsculas,
                <%= deltaMinusculas %> minúsculas y
                <%= deltaNumeros    %> números </p>
        </div>

        <%
        } else {
        %>
        <div class="col-md-6 text-center">
            <h1 class="display-4 mb-4">¡Acceso Concedido!</h1>
            <div class="alert alert-success" role="alert">
                <p class="mb-0">Bienvenido al sistema. Tu acceso ha sido verificado correctamente.<br>
                    Tu contraseña
                    <es></es>
                    segura
                </p>
            </div>
            <p class="lead mb-4">Ahora puedes acceder a todas las funciones de nuestra plataforma.</p>
        </div>
        <%
            }
        %>
    </div>
</div>

<!-- Bootstrap JS (opcional, solo si necesitas componentes de Bootstrap que requieran JS) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</body>
</html>